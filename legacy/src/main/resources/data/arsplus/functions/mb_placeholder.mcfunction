execute as @e[type=item,nbt={Item:{id:"arsplus:mana_barrel_placeholder"}}] at @s run effect give @a[r=..5] mana-and-artifice:instant-mana 1 9
execute as @e[type=item,nbt={Item:{id:"arsplus:mana_barrel_placeholder"}}] at @s run particle soul ~ ~ ~ 1 0 1 0 15
#summon area_effect_cloud ~ ~ ~ {Particle:"soul",Radius:3f,RadiusPerTick:-0.1f,Duration:600,DurationOnUse:5f,WaitTime:10,Potion:"minecraft:water",Effects:[{Id:"mana-and-artifice:mana-regen",Amplifier:3b,Duration:200,ShowParticles:1b}]}
execute as @e[type=item,nbt={Item:{id:"arsplus:mana_barrel_placeholder"}}] at @s run kill @s
scoreboard players set @s mb_placeholder 0