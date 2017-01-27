package Textadventure;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/*
 *  In dieser Klasse werden alle beschreibenden Texte gespeichert, sowie eine Funkntion zur Ausgabe eben dieser.
 */
public class Texte implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2940956972445583987L;

	private static Map<String, String> textsByName;
	
	static final Map<String, String> TEXTS_BY_NAME;
	static {
		textsByName = new HashMap<>();
		textsByName.put("no","\nUngültige Eingabe\n\n");
		textsByName.put("start","\nDu stehst in einem düsteren Raum. Alles scheint merkwürdig surreal. Du weisst, dass du dich nicht in der physikalischen Welt befindest. Das einzige Licht scheint von den Wänden selbst zu kommen.\nUm dich zu bewegen oder mit Objekten zu interagieren, gib die Befehle in den runden Klammern ein und bestätige mit Enter.\n>(ok)");
		textsByName.put("f1","\nVor dir erstreckt sich ein leerer Gang, dessen Ende du nicht sehen kannst, da er in der Dunkelheit verschwindet. Rechts und links an den Wänden siehst du je eine Tür. \n>weiter gehen\t\t(weiter)\n>linke Tür ansehen\t(links)\n>rechte Tür ansehen\t(rechts)\n");
	    textsByName.put("f2","\nVor dir erhellt sich ein Teil des Ganges. Du siehst erneut links und rechts je eine Tür.\n>weiter gehen\t\t(weiter)\n>linke Tür ansehen\t(links)\n>rechte Tür ansehen\t(rechts)\n>zurueckgehen\t\t(zurueck)\n");
	    textsByName.put("f3","\nVor dir erhellt sich der Rest des Ganges und du kannst das Ende erkennen. Links und rechts siehst du je eine weitere Tür.\n>linke Tür ansehen\t(links)\n>rechte Tür ansehen\t(rechts)\n>zurueckgehen\t\t(zurueck)\n");
	    textsByName.put("l1","\nDu stehst vor einer gewöhnlichen Holztür. An ihr hängt ein Schild mit der Aufschrift \"Verwaltung\".\n>Tür öffnen\t(auf)\n>zurueckgehen\t(zurueck)\n");
	    textsByName.put("l1A","\nDie Tür öffnet sich, wie von alleine. Du findest dich in einem sehr kahl wirkenden Raum wieder. Direkt vor dir steht ein riesiger Aktenschrank. An der linken Wand steht das gleiche Modell noch einmal. Beide scheinen geradezu überzuquellen und eigentlich auch viel zu gross zu sein für diesen kleinen Raum. In der gegenüberliegenden Ecke steht ein unscheinbarer Safe.\n>vorderen Aktenschrank näher ansehen\t(aktenV)\n>linken Aktenschrank nähere ansehen\t(aktenL)\n>Safe untersuchen\t\t\t(safe)\n>Raum verlassen\t\t\t\t(raus)\n");
	    textsByName.put("l1B","\nDirekt vor dir steht ein riesiger Aktenschrank. An der linken Wand steht das gleiche Modell noch einmal. Beide scheinen geradezu überzuquellen. In der gegenüberliegenden Ecke steht ein unscheinbarer Safe.\n>vorderen Aktenschrank näher ansehen\t(aktenV)\n>linken Aktenschrank nähere ansehen\t(aktenL)\n>Safe untersuchen\t\t\t(safe)\n>Raum verlassen\t\t\t\t(raus)\n");
	    textsByName.put("a1","\nDu siehst dir einige der obersten Akten näher an. Es handelt sich um alle Arten von Rechnungen. Du trittst davon zurück.\n");
	    textsByName.put("a2","\nDu blätterst dich durch einige der Akten. Es sind Bilanzen und Statistiken zur Entwicklung von MediTech. Du gehst zurück zum Eingang des Raumes.\n");
	    textsByName.put("safe","\nDu siehst dir den Safe näher an. Die Tür ist mit einem Rätselschloss gesichert.\n");
	    textsByName.put("r1", "\nDu stehst vor einer makellos weissen Tür mit der Aufschrift \"Medikamente\".\n>Tür öffnen\t(auf)\n>zurueckgehen\t(zurueck)\n");
		textsByName.put("r1A","\nDu betrittst einen sterilen, weissen Raum. Er ähnelt einem medizinischen Labor. Du siehst einen Medizinschrank, sowie einen Aktenschrank.\n>Aktenschrank untersuchen\t(akten)\n>Medizinschrank untersuchen\t(medizin)\n>Raum verlassen\t\t\t(raus)\n");
		textsByName.put("r1B","\nDu siehst einen Medizinschrank, sowie einen Aktenschrank.\n>Aktenschrank untersuchen\t(akten)\n>Medizinschrank untersuchen\t(medizin)\n>Raum verlassen\t\t\t(raus)\n");
		textsByName.put("a3","\nDie Akten enthalten Berichte über verschiedene Medikamente und ihre Wirkungen. Du kannst wenige der Fachbegriffe verstehen und gehst zurück zum Eingang des Raumes.\n");
		textsByName.put("m","\nDer Schrank enthält allerlei Fläschchen und Döschen mit kompliziert klingenden Aufschriften. Du kannst mit keinem davon etwas anfangen und trittst zurück.\n");
		textsByName.put("l2","\nDu stehst vor einer sehr massiv wirkenden Tür. Sie ist verschlossen.\n>Passwort eingeben (?)\n>zurueckgehen\t(zurueck)\n");
		textsByName.put("l2A","Du stehst in einem Raum voller technologischer Gerätschaften. In der Mitte siehst du eine grosse Maschine von der aus Kabel in alle Richtungen und in die Wände des Raumes hinein laufen. An der Maschine ist eine gewaltige Menge Dynamit befestigt. Die Zündschnur führt bis direkt vor deine Füsse.\n>Raum verlassen\t\t(raus)\n");
		textsByName.put("l2B","Du stehst in einem Raum voller technologischer Gerätschaften. In der Mitte siehst du eine grosse Maschine von der aus Kabel in alle Richtungen und in die Wände des Raumes hinein laufen. An der Maschine ist eine gewaltige Menge Dynamit befestigt. Die Zündschnur führt bis direkt vor deine Füsse.\n>Dynamit anzünden\t(dynamit)\n>Raum verlassen\t\t(raus)\n");
		textsByName.put("d","Du entfachst dein Feuerzeug und führst es an das Ende der Zündschnur. Sie entflammt sofort und das Feuer rast der riesigen Maschinerie entgegen.\n3...\n2...\n1...\n");
		textsByName.put("r2","\nDu stehst vor einer einladend wirkenden Tür. An ihr hängt ein Schild mit der Aufschrift \"Kunden\".\n>Tür öffnen\t(auf)\n>zurueckgehen\t(zurueck)\n");
		textsByName.put("r2A","\nDie Tür geht auf und du findest dich in einem gemütlich wirkenden Raum wieder. Du siehst einige, dir völlig unbekannte, Menschen. Sie schauen ziellos umher, wirken aber glücklich. Darunter fallen dir zwei Männer und eine Frau auf, die besonders zufrieden scheinen. An der gegenüberliegenden Wand kannst du einen grossen Aktenschrank erkennen.  Daneben ist eine weitere Tür.\n>kleinen Mann ansprechen\t(klein)\n>grossen Mann ansprechen\t(gross)\n>Frau ansprechen\t\t(frau)\n>Aktenschrank untersuchen\t(akte)\n>zur Tür gehen\t\t\t(tuer)\n>zurück in den Flur gehen\t(zurueck)\n");
		textsByName.put("r2b","\nIn der Menge fallen dir zwei Männer und eine Frau auf, die besonders zufrieden scheinen. An der gegenüberliegenden Wand kannst du einen grossen Aktenschrank erkennen.  Daneben ist eine weitere Tür.\n>kleinen Mann ansprechen\t(klein)\n>grossen Mann ansprechen\t(gross)\n>Frau ansprechen\t\t(frau)\n>Aktenschrank untersuchen\t(akte)\n>zur Tür gehen\t\t\t(tuer)\n>zurück in den Flur gehen\t(zurueck)\n");
		textsByName.put("um1","\n\"Marcel Held. 45 Jahre alt. Wurde durch das schnelle Notrufsignal des MediChips vor dem Tod durch Herzinfarkt bewahrt.\"\n");
		textsByName.put("um2","\n\"Marco Riet. 24 Jahre alt. Seit des Einsatzes des MediChips keine Erkrankungen.\"\n");
		textsByName.put("uf","\n\"Julia Kosi. 38 Jahre alt. Der MediChip diagnostizierte einen hoch aggressiven Krebs in einem sehr frühen Stadium, sodass ich behandelt werden konnte, Monate bevor die ersten Symptome auftraten.\"\n");
		textsByName.put("a4","\nDer Schrank enthält massenweise Patientenakten. Sie berichten alle von zufriedenen Kunden von MediTech und darunter sind auch viele Erfolgsgeschichten von Menschen, die Dank des MediChips überlebt haben.\n");
		textsByName.put("r4","\nDu stehst vor einer dunklen, mit Gitterstäben versehenen Tür. Hinter den Gitterstäben kannst du in kleinen Buchstaben die Aufschrift \"Testsubjekte\" erkennen.\n>Türe öffnen\t(auf)\n>zurück treten\t(zurueck)\n");
		textsByName.put("r4A","Du betrittst einen düsteren Raum. Dir drängt sich ein unwohles Gefühl auf und du siehst einige recht verwahrlost aussehende Menschen. In einer Ecke steht ein Aktenschrank.\n>in der Ecke kauernden Menschen ansprechen\t\t(ecke)\n>zappeligen Typ in der Mitte des Raumes ansprechen\t(mitte)\n>schelmisch grinsenden jungen Mann ansprechen\t\t(grins)\n>auf einem Stuhl sitzenden Mann ansprechen\t\t(stuhl)\n>Aktenschrank untersuchen\t\t\t\t(akten)\n>Raum verlassen\t\t\t\t\t\t(raus)\n");
		textsByName.put("r4B","Du siehst vier recht verwahrlost aussehende Menschen. In einer Ecke steht ein Aktenschrank.\n>in der Ecke kauernden Menschen ansprechen\t\t(ecke)\n>zappeligen Typ in der Mitte des Raumes ansprechen\t(mitte)\n>schelmisch grinsenden jungen Mann ansprechen\t\t(grins)\n>auf einem Stuhl sitzenden Mann ansprechen\t\t(stuhl)\n>Aktenschrank untersuchen\t\t\t\t(akten)\n>Raum verlassen\t\t\t\t\t\t(raus)\n");
		textsByName.put("t1","\"Testsubjekt 312. 13 Monate in intensiver Behandlung. Danach Einweisung in psychiatrische Klinik, aufgrund schwerer Angstzustände.\" \n");
		textsByName.put("t2","\"Testsubjekt 398. Nach einmonatigen Tests traten körperliche Einschränkungen in Form von Verlust der Kontrolle über die Gliedmassen auf. Ursache dafür ist ein Schaden am Nervensystem.\"\n");
		textsByName.put("t3","\"Testsubjekt 143. Entwicklung eines starken Verfolgungswahnes nach Einsatz des MediChip. Einweisung in eine psychiatrische Klinik nach 23 monatigen Tests.\"\n");
		textsByName.put("t4","\"Testsubjekt 402. 3 Monate nach Einsetzen des MediChips traten starke Kopfschmerzen auf. In den folgenden Monaten kontinuierlicher Verlust des Denkvermögens. Derzeit 6 Monate in Behandlung.\"\n");
		textsByName.put("a7","Der Aktenschrank enthält Dokumente, die genau die Tests an den Menschen festhalten, die in der MediTech-Institution leben. Viele der Menschen scheinen irgendeinen physischen oder psychischen Defekt zu haben. Mehr lässt sich hier nicht herausfinden.\n");
		textsByName.put("l3","\nDu stehst vor einer offiziell wirkenden Tür mit der Aufschrift \"Mitarbeiter\".\n>Tür öffnen\t(auf)\n>zurueckgehen\t(zurueck)\n");
		textsByName.put("l3A","\nDu betrittst den Raum und findest dich in einem ordentlichen Zimmer wieder. Viele Doktoren stehen herum und an der Wand zu deiner Rechten steht ein Aktenschrank. Am der gegenüberliegenden Wand führt eine weitere Tür aus dem Raum hinaus.\n>Dr. Y ansprechen\t\t(dry)\n>Dr. X ansprechen\t\t(drx)\n>hibbeligen Doktor ansprechen\t(hibbel)\n>Aktenschrank untersuchen\t(akten)\n>Tür ansehen\t\t\t(tuer)\n>zurück in den Flur gehen\t(zurueck)\n");
		textsByName.put("l3B","\nViele Doktoren stehen herum und an der Wand zu deiner Rechten steht ein Aktenschrank. Am der gegenüberliegenden Wand führt eine weitere Tür aus dem Raum hinaus.\n>Dr. Y ansprechen\t\t(dry)\n>Dr. X ansprechen\t\t(drx)\n>hibbeligen Doktor ansprechen\t(hibbel)\n>Aktenschrank untersuchen\t(akten)\n>Tür ansehen\t\t\t(tuer)\n>zurück in den Flur gehen\t(zurueck)\n");
		textsByName.put("dry","\n\"Dr. Y. Seit 24 Monaten bei MediTech angestellt. Habe mich wiederholt gegen den derzeitigen Umgang mit den Patienten ausgesprochen.\"\n");
		textsByName.put("drx","\n\"Dr. X. Seit 19 Monaten bei MediTech angestellt. Stehe unter Verdacht mit der Restistance zusammenzuarbeiten. Werde beobachtet.\"\n");
		textsByName.put("s","\n\"Dr. S. Seit 9 Monaten bei Meditech angestellt. Unauffälliger Mitarbeiter.\"\n");
		textsByName.put("a5","\nDer Schrank enthält eine detaillierte Akte zu jedem Mitarbeiter, der je für MediTech gearbeitet hat. Bei einigen Angestellten gibt es einen Vermerk darüber, dass sie der Zusammenarbeit mit der Restistance verdächtigt werden. Dazu gehört auch Dr.X.\n");
		textsByName.put("l4","\nDie Tür sieht sehr hochwertig aus. An ihr ist ein Schild mit verschnörkelter Schrift befestigt. Darauf ist \"Führungsetage\" zu lesen.\n>Tür öffnen\t(auf)\n>zurücktreten\t(zurueck)\n");
		textsByName.put("l4A","\nDu betrittst den nächsten Raum. Auf den ersten Blick erkennst du, dass die Leute hier sehr viel besser gekleidet sind, als in dem Raum zuvor. Du siehst Max Cornwall, und auch Dr. Schmidt erkennst du wieder.  Im hinteren Teil des Raumes steht ein Aktenschrank und dahinter erkennst du im Schatten eine weitere Gestalt.\n>Aktenschrank untersuchen\t\t\t(akten)\n>Dr. Schmidt ansprechen\t\t\t\t(schmidt)\n>Cornwall ansprechen\t\t\t\t(cornwall)\n>schattenhafte Gestalt ansprechen\t\t(schatten)\n>Raum verlassen\t\t\t\t\t(raus)\n");
		textsByName.put("l4B","\nDu siehst Max Cornwall, und auch Dr. Schmidt erkennst du wieder.  Im hinteren Teil des Raumes steht ein Aktenschrank und dahinter erkennst du im Schatten eine weitere Gestalt.\n>Aktenschrank untersuchen\t\t\t(akten)\n>Dr. Schmidt ansprechen\t\t\t\t(schmidt)\n>Cornwall ansprechen\t\t\t\t(cornwall)\n>schattenhafte Gestalt ansprechen\t\t(schatten)\n>Raum verlassen\t\t\t\t\t(raus)\n");
		textsByName.put("a6","Der Schrank ist relativ leer. Die Akten beschreiben vorbildliche Mitarbeiter, die allesamt einen grossen Beitrag zur Entwicklung MediTechs beigetragen haben. Besonders ins Auge fällt dir eine Akte deren Inhalt grössten Teils herausgeschwärzt wurde, als wäre sie zensiert. Auf einer Seite erkennst du noch den Namen John Dahl.\n");
		textsByName.put("smt","Dr. Schmidt. Derzeitige Oberärztin der MediTech Institution am Standort Finkenau. Habe ein neues System zur Verwaltung und Auswertung von Patientendaten entwickelt. Sehr geschätzte Mitarbeiterin.\"\n");
		textsByName.put("ceo","\"Ich bin Max Cornwall, der Kopf von MediTech. Nur ich kenne das Passwort zum zentralen Serverraum.\n Aber solange du unbewaffnet bist werde ich nicht gegen dich kämpfen.\"");
		textsByName.put("dahl","\"John Dahl. Ehemaliger Mitarbeiter von MediTech. XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX\"\n");
		textsByName.put("r3","Du stehst vor einer etwas schäbigen Tür. In leicht verblasster Schrift steht darauf \"Abstellraum\".\n>Tür öffnen\t(auf)\n>zurück gehen\t(zurueck)\n");
		textsByName.put("r3A","Du findest dich in einem kleinen Kabuff wieder. Zu deiner linken steht ein gewöhnlicher Schrank, rechts ein alter Spind und vor dir ein abgenutzter Tisch. In der gegenüberliegenden Ecke steht eine Werkbank.\n>Schrank öffnen\t\t(schrank)\n>Spind öffnen\t\t(spind)\n>Tisch untersuchen\t(tisch)\n>Werkbank näher ansehen\t(werkbank)\n>zurück in den Flur\t(zurueck)\n");
		textsByName.put("r3B","Zu deiner linken steht ein gewöhnlicher Schrank, rechts ein alter Spind und vor dir ein abgenutzter Tisch. In der gegenüberliegenden Ecke steht eine Werkbank.\n>Schrank öffnen\t\t(schrank)\n>Spind öffnen\t\t(spind)\n>Tisch untersuchen\t(tisch)\n>Werkbank näher ansehen\t(werkbank)\n>zurück in den Flur\t(zurueck)\n");
		textsByName.put("sr","Der Schrank enthält diverse Putzmittel und einige schmuddelige Lappen.\n");
		textsByName.put("sp","Auf dem Boden des Spinds steht ein Eimer mit einem Mopp.\n");
		textsByName.put("t","Auf dem Tisch liegen eine halbleere Schachtel Zigaretten, ein Feuerzeug und etwas Kleingeld.\n>Geld näher ansehen\t(geld)\n>Feuerzeug testen\t(feuer)\n>zurücktreten\t\t(zurueck)\n");
		textsByName.put("g","2,34 Euro in kleinen Münzen.\n");
		textsByName.put("f0","Ein funktionierendes Feuerzeug.\n>mitnehmen\t(nimm)\n>zurück legen\t(zurueck)");
		textsByName.put("f","Du steckst es ein.\n");
		textsByName.put("wb","Auf der Werkbank findest du eine Schere, einen Stein und ein Blatt Papier.\n>Schere untersuchen\t(schere)\n>Stein untersuchen\t(stein)\n>Papier näher ansehen\t(papier)\n>Alles mitnehmen (nimm)\n>zurücktreten\t\t(zurueck)\n");
		textsByName.put("sch","Eine spitze, silberne Schere.\n");
		textsByName.put("st", "Ein scharfkantiger, faustgroßer Stein.\n");
	    textsByName.put("pa", "Ein gewöhnliches, weißes Blatt Papier.\n");
	    TEXTS_BY_NAME = Collections.unmodifiableMap(textsByName);
	}
	
	public String getText(String index){
		String text;
		text = textsByName.get(index);
		return text;
	}
	
	public void setText(String index, String text){
		textsByName.put(index, text);
	}
	
}


