module finalreality.main {
  requires javafx.controls;
  requires org.jetbrains.annotations;
  requires org.apache.commons.lang3;
  requires junit;
  exports cl.uchile.dcc.finalreality.model.weapon;
  exports cl.uchile.dcc.finalreality.model.character;
  exports cl.uchile.dcc.finalreality.model.spells;
  exports cl.uchile.dcc.finalreality.model.states;
  exports cl.uchile.dcc.finalreality.exceptions;

}