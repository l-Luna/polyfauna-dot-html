# luna's various projects

{lu}i've done a couple things, huh?{!}

## celeste modding

{lu}my first celeste mod was [AltSidesHelper](https://github.com/l-Luna/AltSidesHelper), which allowed adding extra side-levels (called *alt-sides*) with more flexibility and control than vanilla allowed. this is where i learned C# and the C# modding tools; ASH includes a *lot* of small modifications throughout the game, and while i still want to redo much of it, i'd say it's fairly impressive for a first mod & fairly clean for what it is.{!}

{lu}i also have a personal "helper" mod, [prismatic helper](https://github.com/l-Luna/PrismaticHelper), which i update over time with new mechanics for anyone to use. maybe i'm biased, but i think some of them are pretty damn cool: simplified cutscenes that don't require programming knowledge, levels-in-levels, and smaller things like "doors with multiple locks" as i need them{!}

{lu}there's a lot more i had planned to put into it, but nowadays i tend to bundle code with specific maps, and split things up more finely, since it reduces the maintenance load significantly. sometimes i'll make it public later, like [the tile layout anchor](https://gamebanana.com/mods/504071) originally created for [SSC3](https://gamebanana.com/mods/532531), but otherwise it's on a request basis{!}

{lu}speaking of requests, i've done a lot of little things for collaborative projects over time, including [SSC3](https://gamebanana.com/mods/532531), [FLP](https://gamebanana.com/mods/425041), and contributions to [communal helper](https://github.com/CommunalHelper/CommunalHelper){!}

{lu}oh, and i also work on this little map editor project called [snowberry](https://github.com/l-Luna/snowberry), check it out sometime{!}

## opus magnum modding

{lu}i set up the opus magnum mod loader, [quintessential](https://github.com/QuintessentialOM/Quintessential), inspired by & using tools from [the celeste mod loader](https://github.com/EverestAPI/Everest), alongside my own custom [deobfuscation tool](https://github.com/QuintessentialOM/OpusMutatum). to make that easier to use, i began on a [GUI mod installer](https://github.com/QuintessentialOM/Alkahest), though it remains unfinished{!}

{lu}i also made the first content mod for it, [unstable elements](https://github.com/l-Luna/UnstableElements), and the first utility mod [zoom tool](https://github.com/l-Luna/ZoomTool){!}

{lu}in the leadup to the [bot-making contest](https://old.reddit.com/r/opus_magnum/comments/1chs6eu/opus_magnum_24hour_challenge/), i made a java library for reading and manipulating OM puzzle & solution files, called [omnivore](https://github.com/l-Luna/omnivore), which later become my first [published](https://central.sonatype.com/artifact/io.github.l-luna/omnivore/overview) package{!}

## minecraft modding

{lu}have you ever heard of this little game called "minecraft"? yeah it's pretty cool{!}

{lu}MC modding is where i learned to program, so naturally i have an unending pile of unfinished projects there. most of them i don't really have anymore either, so... they're not getting mentions. just imagine i listed like 15 one-item mods.{!}

{lu}in fact, i'd say i've only ever finished two. [automotons](https://github.com/l-Luna/Automotons) has you building and programming robots called *automotons*, using items as simple instructions & with an ingame guidebook to help you. i'm still pretty proud of the design!{!}

{lu}i also made an addon for [thaumcraft 6](https://www.curseforge.com/minecraft/mc-mods/thaumcraft) called [planar artifice](https://github.com/l-Luna/planar-artifice); a mod for a mod, it was a pretty random bundle of new features that i thought were cool really, but some of those involved messing with TC6 itself and doing things i haven't seen elsewhere. after almost losing the code, i put it on github and made is free-to-use, and someone else [picked it up](https://www.curseforge.com/minecraft/mc-mods/planar-artifice) and ran with the ideas. i'm not sure where they ran *to* exactly{!}

{lu}my best work has probably been in [arcana](https://github.com/l-Luna/ArcanaEx), an unfinished spiritual successor to thaumcraft. it's development has gone through many, many, many... hoops, but i'm very happy with its current state, and intend to finish it sometime. (i mean, it's playable now! just ignore the bugs){!}

## programming languages

{lu}i'm a big fan of programming language design, and a while back i tried my hoof at making one myself: [cyclic](https://github.com/l-Luna/CyclicCompiler), which was largely based on java, with an increasing number of incremental changes (and entirely separate compiler/tools). i never ended up getting to "the point" of the language; at some point i started rewriting it entirely to facilitate the metaprogramming i wanted to implement, but never finished, *sigh*{!}

{lu}but a compiler alone does not a language make! i also made an [intellij plugin](https://github.com/l-Luna/CyclicIntellijPlugin) and [gradle plugin](https://github.com/l-Luna/CyclicGradle) for it, allowing you to write cyclic code in IJ & compile it with gradle, *and* even have a fairly pleasant experience! turns out that implementing *incredibly* minor IDE features for your language can be incredibly satisfying too{!}

{lu}(also means i'm no longer scared of the gradle demons - you have no power over me anymore!){!}

## open source stuff

{lu}i've helped out with the [IJ MCdev plugin](https://github.com/minecraft-dev/MinecraftDev) and the [IJ ANTLR plugin](https://github.com/antlr/intellij-plugin-v4), adding features that i felt were sorely missing ("copy access widener" fix my beloved). i also helped out with [everest](https://github.com/EverestAPI/Everest); while i'd like to do more there, it's a living interconnected ~~spaghetti~~ project that requires much more time and planning to change.{!}

{lu}also, i spent a while working on the [vineflower](https://github.com/Vineflower/vineflower) java decompiler, particularly on decompiling pattern matching & formulating the plugin system{!}

## rust shenanigans

{lu}i made a crate for implementing garbage collection in rust called [swifer](https://github.com/l-luna/swifer), which i then [published](https://crates.io/crates/swifer). funnily enough, this was a while before i ever *published* a java project.{!}

{lu}i have various other tiny things lying around, like an interactive demonstration of principal component analysis to help with my revision - it's a pretty fun language for prototyping imo{!}