package polyfauna.website;

import org.commonmark.Extension;
import org.commonmark.ext.front.matter.YamlFrontMatterExtension;
import org.commonmark.ext.front.matter.YamlFrontMatterVisitor;
import org.commonmark.ext.gfm.strikethrough.StrikethroughExtension;
import org.commonmark.ext.gfm.tables.TablesExtension;
import org.commonmark.ext.heading.anchor.HeadingAnchorExtension;
import org.commonmark.node.AbstractVisitor;
import org.commonmark.node.Link;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.*;
import java.util.List;
import java.util.Map;

public class Main{
	
	private static final List<String> memberTags = List.of(
			"li", "lu", "ch", "ha", "re", "dy",
			"poly"
	);
	
	
	
	public static void main(String[] args) throws IOException{
		Path rootPath = Path.of("./pages").toAbsolutePath().normalize();
		if(!Files.exists(rootPath) || !Files.isDirectory(rootPath)){
			System.err.println("could not find pages directory at " + rootPath);
			return;
		}
		Path targetPath = Path.of("./out").toAbsolutePath().normalize();
		Files.createDirectories(targetPath);
		
		try(var f = Files.walk(rootPath)){
			f.forEach(path -> apply(rootPath, targetPath, path.normalize()));
		}
		
		System.out.println("done!");
	}
	
	private static void apply(Path root, Path target, Path path){
		if(!Files.isRegularFile(path))
			return;
		Path resolved = target.resolve(root.relativize(path));
		try{
			if(path.toString().endsWith(".md")){
				resolved = resolved.getParent().resolve(resolved.getFileName().toString().replace(".md", ".html"));
				
				String text = Files.readString(path);
				String html = renderMarkdown(text);
				Files.createDirectories(resolved.getParent());
				Files.writeString(resolved, html, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
			}else{
				Files.createDirectories(resolved.getParent());
				Files.copy(path, resolved, StandardCopyOption.REPLACE_EXISTING);
			}
		}catch(IOException e){
			throw new UncheckedIOException(e);
		}
	}
	
	private static String renderMarkdown(String md) throws IOException{
		List<Extension> extensions = List.of(
				StrikethroughExtension.create(),
				TablesExtension.create(),
				HeadingAnchorExtension.create(),
				YamlFrontMatterExtension.create()
		);
		Parser parser = Parser
				.builder()
				.extensions(extensions)
				.postProcessor(node -> {
					node.accept(new AbstractVisitor(){
						public void visit(Link link){
							super.visit(link);
							String destination = link.getDestination();
							if(destination.endsWith(".md"))
								link.setDestination(destination.substring(0, destination.length() - 3) + ".html");
						}
					});
					return node;
				})
				.build();
		Node document = parser.parse(md);
		YamlFrontMatterVisitor yamlVisitor = new YamlFrontMatterVisitor();
		document.accept(yamlVisitor);
		Map<String, List<String>> yamlData = yamlVisitor.getData();
		HtmlRenderer renderer = HtmlRenderer
				.builder()
				.extensions(extensions)
				.build();
		
		String rendered = renderer.render(document);
		
		// dirty string replacement for member colours
		for(String tag : memberTags)
			rendered = rendered.replace("{" + tag + "}", "<span class=\"" + tag + "Text\">");
		rendered = rendered.replace("{!}", "</span>");
		
		// handle template replacements
		String type = yamlData.getOrDefault("template", List.of("default")).getFirst();
		return handleSubstitutions(Files.readString(Path.of("./templates", type + ".html")), yamlData, type, rendered);
	}
	
	private static String handleSubstitutions(String template, Map<String, List<String>> data, String type, String rendered){
		// add additional styles
		StringBuilder styles = new StringBuilder();
		for(String style : data.getOrDefault("styles", List.of()))
			styles.append("<link rel=\"stylesheet\" href=\"./").append(style).append(".css\">\n\t");
		template = template.replace("[[STYLES]]", styles);
		
		// YAML-defined substitutions
		for(String substitute : data.getOrDefault("substitutions", List.of())){
			var split = substitute.split("=");
			template = template.replace("[[" + split[0].trim() + "]]", split[1].trim());
		}
		
		// this stays last, introduces the most text
		template = template.replace("[[CONTENT]]", rendered);
		
		return template;
	}
}