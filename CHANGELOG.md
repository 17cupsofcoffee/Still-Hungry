#CHANGELOG:
##Version 2.1.1:

* Translations into Russian, German and French.
* The lunchbox is functional again after being broken in 2.1.0. The functionality of it has also changed; each lunchbox now has an individual inventory instead of there being one per player. (Issue #8)
* Sprites and textures were updated to add more color and contrast, as well as fixing some consistency issues.
* The cheese recipe was changed to fix the issue with buckets duplicating in the furnace. You now receive a bucket of cheese when you cook milk, which can then be crafted into a block of cheese - this will return the bucket as normal. (Issue #7)
* The mod now has a creative mode tab especially for its items. Also if you start a new world, you should notice the items are in a bit of a more sensible order in creative. (Issue #9)
* The barrel can now be crafted from any wood type, including wood from other mods and the newer types of wood added in recent Minecraft updates. (Issue #13)
* Shift clicking functionality was added to the stove and lunchbox. This will be added to the barrel in a later update. (Issue #5)
* A bug with the barrel not draining water from water buckets was fixed. (Issue #16)

##Version 2.1.0

* General code restructuring.
* ID conflicts are no longer an issue due to the changes made in Minecraft 1.7.
* Grapes can now be harvested by right clicking. This is to make our mod more consistent with other plant mods (Natura especially). This functionality will be added to the strawberries in a later update.
* Bonemeal nerfed to be more in line with the amount used in vanilla Minecraft. One bonemeal will now increase plant growth by one stage.
* French Toast is now made using bread and eggs rather than bread and butter.
* Eating Mac and Cheese or Fruit Salad now returns the bowl used in the crafting recipe.
* Killing a sheep with a Fire Aspect enchant now gives cooked meat, as with the vanilla animals.
* Buckets being returned after making cheese is now more reliable. (Issue #4)

##Version 2.0.1
* General bugfixes and code cleanup.
* Shift clicking in the stove/barrel/lunchbox no longer causes crashes. (Issue #2)
* The stove now accepts fuel items added in Minecraft 1.6, such as the coal block. (Issue #3)
* The bucket used in the cheese crafting recipe is now returned to the player. (Issue #4)
* Hoppers attached to the stove/barrel no longer crash the game. They are not functional yet, however - this will be added in a later update.

##Version 2.0.0
WARNING: Versions from this point on were not very well documented and did not have their issues recorded on the GitHub issue tracker. Some changes may not get listed here!
* General codebase cleanup and optimization.
* This is the first release to be made open source on GitHub (under the LGPL licence).
* Lunchboxes have been added - a portable 6 slot food inventory.
* Grapes have been added, and a barrel with which to make wine and cider.
* The spawn rates of rice and strawberries were lowered.
* The sprite for the mug item was replaced.
* The french toast recipe now uses butter instead of oil.
* The maximum stack sizes of some items were lowered.
* Frying pans now lose durability when used in the stove.

##Version 1.0.2
* Code refactoring and cleanup - namely, a proper package structure and build script were added.
* Added a config file (located in .minecraft/config after the first run of the mod) which can be used to fix block/item ID conflicts.
* Fixed a bug where bonemeal could be used without being consumed.

##Version 1.0.1
* Stove recipe changed in order to remove conflicts with IC2 and FTB.
* Flour recipe changed in order to remove conflict with Chococraft.
* The sprite for the strawberry item was replaced.
* The drop rate for plants was made more frequent.
* Seeds can now be obtained by placing their associated crop into the crafting grid.
* An mcmod.info file was added (information is now available in the mods page on the title screen).

##Version 1.0.0
* First release!