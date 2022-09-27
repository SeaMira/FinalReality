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

* _Enemies_ have their own damage and weight.
* _PlayerCharacters_ can equip a weapon.





