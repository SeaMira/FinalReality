Final Reality
=============

![http://creativecommons.org/licenses/by/4.0/](https://i.creativecommons.org/l/by/4.0/88x31.png)

This work is licensed under a 
[Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/)

Context
-------

This project's goal is to create a (simplified) clone of _Final Fantasy_'s combat, a game developed
by [_Square Enix_](https://www.square-enix.com)
Broadly speaking for the combat the player has a group of characters to control and a group of 
enemies controlled by the computer.

---

Classes structure
-----------------

### Characters

To make a character, it was defined a hierarchical order where GameCharacter presents the
most generic type of character in this game, since enemies, (possible npc's) and playable 
characters share this type. GameCharacters have a Name, a maximum amount of health points 
(maxHp), a defense value and will have a queue that is going to store the turns.

Then multiples classes are derived until we specialize characters: 

* _Enemies_ have their own damage and weight. Is an extensible class since we can make different
types of enemies, but for now there's just SimpleEnemy (in another class).


* _PlayerCharacters_ can equip a weapon. Since every playable character can
equip a wapon, this class is also extensible and this is what has been done: we have "normal"
characters for knight, engineer and thief, and then we have the Mages (another class), for blackmage 
and whitemage.

### Weapons
To create a Weapon there's a similar idea: a class Weapon that contains the general
weapon characteristics (name, damage and weight), and from this it is possible to extend it to different kind of 
weapons, like the magicweapons where we defined Staff (a weapon just for mages), but there are
also tagged weapons based on his range of attack, for example (this is done with interfaces) Bow,
a long-range weapon, or a Sword a melee weapon.

Funcionality
------------

Every class implements it's getters and
setters, and every not abstract and not interface class has it's own overwritten
_toString()_, _hashCode()_ and _equals()_ methods. For playable characters, since they don't have
their own damage, this is determined with the weapon they are equipped with. Then they can equip a
weapon an for this there's is a _equipWeapon( Weapon )_ method, which let's a weapon be a
part of a playable character's fields. From this we can get a damage and a weight from
a playable character.

Every playable character has a selected group of weapons it can use. These weapons are determined by the class 
of the weapon. For example, a Knight can use a Sword, Knives and an Axe, but not a Staff or a Bow
(every one of those weapons has a class). 

In-Game characteristics
-----------------------

As said before, Enemies can't use a weapon since this is just a playable character's
characteristic, yet they do have weight and damage, so they can participate in a battle.
In this game battles are turn-based it means that every character will have it's own 
turn to make an action. This turn is stablished by some rules:
1. There is a queue where every turn is stored.
2. When we get a character from this queue, it means that is that character's turn.
3. The character makes an action and then has to wait a specific time before been put int the queue again.
4. Repeat.

To get the time every character has to wait, the next formula is used:
* We get the weight from the character (if it's a playable character we get it from his weapon, 
if it's an enemy we get it from himself). Then we divide that weight value by 10.
The waiting time will then be _weight / 10_ seconds.



