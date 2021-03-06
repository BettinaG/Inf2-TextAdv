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
		textsByName.put("no","\nUng�ltige Eingabe\n\n");
		textsByName.put("start","\nDu stehst in einem d�steren Raum. Alles scheint merkw�rdig surreal. Du weisst, dass du dich nicht in der physikalischen Welt befindest. Das einzige Licht scheint von den W�nden selbst zu kommen.\nUm dich zu bewegen oder mit Objekten zu interagieren, gib die Befehle in den runden Klammern ein und best�tige mit Enter.\n>(ok)");
		textsByName.put("f1","\nVor dir erstreckt sich ein leerer Gang, dessen Ende du nicht sehen kannst, da er in der Dunkelheit verschwindet. Rechts und links an den W�nden siehst du je eine T�r. \n>weiter gehen\t\t(weiter)\n>linke T�r ansehen\t(links)\n>rechte T�r ansehen\t(rechts)\n");
	    textsByName.put("f2","\nVor dir erhellt sich ein Teil des Ganges. Du siehst erneut links und rechts je eine T�r.\n>weiter gehen\t\t(weiter)\n>linke T�r ansehen\t(links)\n>rechte T�r ansehen\t(rechts)\n>zurueckgehen\t\t(zurueck)\n");
	    textsByName.put("f3","\nVor dir erhellt sich der Rest des Ganges und du kannst das Ende erkennen. Links und rechts siehst du je eine weitere T�r.\n>linke T�r ansehen\t(links)\n>rechte T�r ansehen\t(rechts)\n>zurueckgehen\t\t(zurueck)\n");
	    textsByName.put("l1","\nDu stehst vor einer gew�hnlichen Holzt�r. An ihr h�ngt ein Schild mit der Aufschrift \"Verwaltung\".\n>T�r �ffnen\t(auf)\n>zurueckgehen\t(zurueck)\n");
	    textsByName.put("l1A","\nDie T�r �ffnet sich, wie von alleine. Du findest dich in einem sehr kahl wirkenden Raum wieder. Direkt vor dir steht ein riesiger Aktenschrank. An der linken Wand steht das gleiche Modell noch einmal. Beide scheinen geradezu �berzuquellen und eigentlich auch viel zu gross zu sein f�r diesen kleinen Raum. In der gegen�berliegenden Ecke steht ein unscheinbarer Safe.\n>vorderen Aktenschrank n�her ansehen\t(aktenV)\n>linken Aktenschrank n�here ansehen\t(aktenL)\n>Safe untersuchen\t\t\t(safe)\n>Raum verlassen\t\t\t\t(raus)\n");
	    textsByName.put("l1B","\nDirekt vor dir steht ein riesiger Aktenschrank. An der linken Wand steht das gleiche Modell noch einmal. Beide scheinen geradezu �berzuquellen. In der gegen�berliegenden Ecke steht ein unscheinbarer Safe.\n>vorderen Aktenschrank n�her ansehen\t(aktenV)\n>linken Aktenschrank n�here ansehen\t(aktenL)\n>Safe untersuchen\t\t\t(safe)\n>Raum verlassen\t\t\t\t(raus)\n");
	    textsByName.put("a1","\nDu siehst dir einige der obersten Akten n�her an. Es handelt sich um alle Arten von Rechnungen. Du trittst davon zur�ck.\n");
	    textsByName.put("a2","\nDu bl�tterst dich durch einige der Akten. Es sind Bilanzen und Statistiken zur Entwicklung von MediTech. Du gehst zur�ck zum Eingang des Raumes.\n");
	    textsByName.put("safe","\nDu siehst dir den Safe n�her an. Die T�r ist mit einem R�tselschloss gesichert.\n");
	    textsByName.put("r1", "\nDu stehst vor einer makellos weissen T�r mit der Aufschrift \"Medikamente\".\n>T�r �ffnen\t(auf)\n>zurueckgehen\t(zurueck)\n");
		textsByName.put("r1A","\nDu betrittst einen sterilen, weissen Raum. Er �hnelt einem medizinischen Labor. Du siehst einen Medizinschrank, sowie einen Aktenschrank.\n>Aktenschrank untersuchen\t(akten)\n>Medizinschrank untersuchen\t(medizin)\n>Raum verlassen\t\t\t(raus)\n");
		textsByName.put("r1B","\nDu siehst einen Medizinschrank, sowie einen Aktenschrank.\n>Aktenschrank untersuchen\t(akten)\n>Medizinschrank untersuchen\t(medizin)\n>Raum verlassen\t\t\t(raus)\n");
		textsByName.put("a3","\nDie Akten enthalten Berichte �ber verschiedene Medikamente und ihre Wirkungen. Du kannst wenige der Fachbegriffe verstehen und gehst zur�ck zum Eingang des Raumes.\n");
		textsByName.put("m","\nDer Schrank enth�lt allerlei Fl�schchen und D�schen mit kompliziert klingenden Aufschriften. Du kannst mit keinem davon etwas anfangen und trittst zur�ck.\n");
		textsByName.put("l2","\nDu stehst vor einer sehr massiv wirkenden T�r. Sie ist verschlossen.\n>Passwort eingeben (?)\n>zurueckgehen\t(zurueck)\n");
		textsByName.put("l2A","Du stehst in einem Raum voller technologischer Ger�tschaften. In der Mitte siehst du eine grosse Maschine von der aus Kabel in alle Richtungen und in die W�nde des Raumes hinein laufen. An der Maschine ist eine gewaltige Menge Dynamit befestigt. Die Z�ndschnur f�hrt bis direkt vor deine F�sse.\n>Raum verlassen\t\t(raus)\n");
		textsByName.put("l2B","Du stehst in einem Raum voller technologischer Ger�tschaften. In der Mitte siehst du eine grosse Maschine von der aus Kabel in alle Richtungen und in die W�nde des Raumes hinein laufen. An der Maschine ist eine gewaltige Menge Dynamit befestigt. Die Z�ndschnur f�hrt bis direkt vor deine F�sse.\n>Dynamit anz�nden\t(dynamit)\n>Raum verlassen\t\t(raus)\n");
		textsByName.put("d","Du entfachst dein Feuerzeug und f�hrst es an das Ende der Z�ndschnur. Sie entflammt sofort und das Feuer rast der riesigen Maschinerie entgegen.\n3...\n2...\n1...\n");
		textsByName.put("r2","\nDu stehst vor einer einladend wirkenden T�r. An ihr h�ngt ein Schild mit der Aufschrift \"Kunden\".\n>T�r �ffnen\t(auf)\n>zurueckgehen\t(zurueck)\n");
		textsByName.put("r2A","\nDie T�r geht auf und du findest dich in einem gem�tlich wirkenden Raum wieder. Du siehst einige, dir v�llig unbekannte, Menschen. Sie schauen ziellos umher, wirken aber gl�cklich. Darunter fallen dir zwei M�nner und eine Frau auf, die besonders zufrieden scheinen. An der gegen�berliegenden Wand kannst du einen grossen Aktenschrank erkennen.  Daneben ist eine weitere T�r.\n>kleinen Mann ansprechen\t(klein)\n>grossen Mann ansprechen\t(gross)\n>Frau ansprechen\t\t(frau)\n>Aktenschrank untersuchen\t(akte)\n>zur T�r gehen\t\t\t(tuer)\n>zur�ck in den Flur gehen\t(zurueck)\n");
		textsByName.put("r2b","\nIn der Menge fallen dir zwei M�nner und eine Frau auf, die besonders zufrieden scheinen. An der gegen�berliegenden Wand kannst du einen grossen Aktenschrank erkennen.  Daneben ist eine weitere T�r.\n>kleinen Mann ansprechen\t(klein)\n>grossen Mann ansprechen\t(gross)\n>Frau ansprechen\t\t(frau)\n>Aktenschrank untersuchen\t(akte)\n>zur T�r gehen\t\t\t(tuer)\n>zur�ck in den Flur gehen\t(zurueck)\n");
		textsByName.put("um1","\n\"Marcel Held. 45 Jahre alt. Wurde durch das schnelle Notrufsignal des MediChips vor dem Tod durch Herzinfarkt bewahrt.\"\n");
		textsByName.put("um2","\n\"Marco Riet. 24 Jahre alt. Seit des Einsatzes des MediChips keine Erkrankungen.\"\n");
		textsByName.put("uf","\n\"Julia Kosi. 38 Jahre alt. Der MediChip diagnostizierte einen hoch aggressiven Krebs in einem sehr fr�hen Stadium, sodass ich behandelt werden konnte, Monate bevor die ersten Symptome auftraten.\"\n");
		textsByName.put("a4","\nDer Schrank enth�lt massenweise Patientenakten. Sie berichten alle von zufriedenen Kunden von MediTech und darunter sind auch viele Erfolgsgeschichten von Menschen, die Dank des MediChips �berlebt haben.\n");
		textsByName.put("r4","\nDu stehst vor einer dunklen, mit Gitterst�ben versehenen T�r. Hinter den Gitterst�ben kannst du in kleinen Buchstaben die Aufschrift \"Testsubjekte\" erkennen.\n>T�re �ffnen\t(auf)\n>zur�ck treten\t(zurueck)\n");
		textsByName.put("r4A","Du betrittst einen d�steren Raum. Dir dr�ngt sich ein unwohles Gef�hl auf und du siehst einige recht verwahrlost aussehende Menschen. In einer Ecke steht ein Aktenschrank.\n>in der Ecke kauernden Menschen ansprechen\t\t(ecke)\n>zappeligen Typ in der Mitte des Raumes ansprechen\t(mitte)\n>schelmisch grinsenden jungen Mann ansprechen\t\t(grins)\n>auf einem Stuhl sitzenden Mann ansprechen\t\t(stuhl)\n>Aktenschrank untersuchen\t\t\t\t(akten)\n>Raum verlassen\t\t\t\t\t\t(raus)\n");
		textsByName.put("r4B","Du siehst vier recht verwahrlost aussehende Menschen. In einer Ecke steht ein Aktenschrank.\n>in der Ecke kauernden Menschen ansprechen\t\t(ecke)\n>zappeligen Typ in der Mitte des Raumes ansprechen\t(mitte)\n>schelmisch grinsenden jungen Mann ansprechen\t\t(grins)\n>auf einem Stuhl sitzenden Mann ansprechen\t\t(stuhl)\n>Aktenschrank untersuchen\t\t\t\t(akten)\n>Raum verlassen\t\t\t\t\t\t(raus)\n");
		textsByName.put("t1","\"Testsubjekt 312. 13 Monate in intensiver Behandlung. Danach Einweisung in psychiatrische Klinik, aufgrund schwerer Angstzust�nde.\" \n");
		textsByName.put("t2","\"Testsubjekt 398. Nach einmonatigen Tests traten k�rperliche Einschr�nkungen in Form von Verlust der Kontrolle �ber die Gliedmassen auf. Ursache daf�r ist ein Schaden am Nervensystem.\"\n");
		textsByName.put("t3","\"Testsubjekt 143. Entwicklung eines starken Verfolgungswahnes nach Einsatz des MediChip. Einweisung in eine psychiatrische Klinik nach 23 monatigen Tests.\"\n");
		textsByName.put("t4","\"Testsubjekt 402. 3 Monate nach Einsetzen des MediChips traten starke Kopfschmerzen auf. In den folgenden Monaten kontinuierlicher Verlust des Denkverm�gens. Derzeit 6 Monate in Behandlung.\"\n");
		textsByName.put("a7","Der Aktenschrank enth�lt Dokumente, die genau die Tests an den Menschen festhalten, die in der MediTech-Institution leben. Viele der Menschen scheinen irgendeinen physischen oder psychischen Defekt zu haben. Mehr l�sst sich hier nicht herausfinden.\n");
		textsByName.put("l3","\nDu stehst vor einer offiziell wirkenden T�r mit der Aufschrift \"Mitarbeiter\".\n>T�r �ffnen\t(auf)\n>zurueckgehen\t(zurueck)\n");
		textsByName.put("l3A","\nDu betrittst den Raum und findest dich in einem ordentlichen Zimmer wieder. Viele Doktoren stehen herum und an der Wand zu deiner Rechten steht ein Aktenschrank. Am der gegen�berliegenden Wand f�hrt eine weitere T�r aus dem Raum hinaus.\n>Dr. Y ansprechen\t\t(dry)\n>Dr. X ansprechen\t\t(drx)\n>hibbeligen Doktor ansprechen\t(hibbel)\n>Aktenschrank untersuchen\t(akten)\n>T�r ansehen\t\t\t(tuer)\n>zur�ck in den Flur gehen\t(zurueck)\n");
		textsByName.put("l3B","\nViele Doktoren stehen herum und an der Wand zu deiner Rechten steht ein Aktenschrank. Am der gegen�berliegenden Wand f�hrt eine weitere T�r aus dem Raum hinaus.\n>Dr. Y ansprechen\t\t(dry)\n>Dr. X ansprechen\t\t(drx)\n>hibbeligen Doktor ansprechen\t(hibbel)\n>Aktenschrank untersuchen\t(akten)\n>T�r ansehen\t\t\t(tuer)\n>zur�ck in den Flur gehen\t(zurueck)\n");
		textsByName.put("dry","\n\"Dr. Y. Seit 24 Monaten bei MediTech angestellt. Habe mich wiederholt gegen den derzeitigen Umgang mit den Patienten ausgesprochen.\"\n");
		textsByName.put("drx","\n\"Dr. X. Seit 19 Monaten bei MediTech angestellt. Stehe unter Verdacht mit der Restistance zusammenzuarbeiten. Werde beobachtet.\"\n");
		textsByName.put("s","\n\"Dr. S. Seit 9 Monaten bei Meditech angestellt. Unauff�lliger Mitarbeiter.\"\n");
		textsByName.put("a5","\nDer Schrank enth�lt eine detaillierte Akte zu jedem Mitarbeiter, der je f�r MediTech gearbeitet hat. Bei einigen Angestellten gibt es einen Vermerk dar�ber, dass sie der Zusammenarbeit mit der Restistance verd�chtigt werden. Dazu geh�rt auch Dr.X.\n");
		textsByName.put("l4","\nDie T�r sieht sehr hochwertig aus. An ihr ist ein Schild mit verschn�rkelter Schrift befestigt. Darauf ist \"F�hrungsetage\" zu lesen.\n>T�r �ffnen\t(auf)\n>zur�cktreten\t(zurueck)\n");
		textsByName.put("l4A","\nDu betrittst den n�chsten Raum. Auf den ersten Blick erkennst du, dass die Leute hier sehr viel besser gekleidet sind, als in dem Raum zuvor. Du siehst Max Cornwall, und auch Dr. Schmidt erkennst du wieder.  Im hinteren Teil des Raumes steht ein Aktenschrank und dahinter erkennst du im Schatten eine weitere Gestalt.\n>Aktenschrank untersuchen\t\t\t(akten)\n>Dr. Schmidt ansprechen\t\t\t\t(schmidt)\n>Cornwall ansprechen\t\t\t\t(cornwall)\n>schattenhafte Gestalt ansprechen\t\t(schatten)\n>Raum verlassen\t\t\t\t\t(raus)\n");
		textsByName.put("l4B","\nDu siehst Max Cornwall, und auch Dr. Schmidt erkennst du wieder.  Im hinteren Teil des Raumes steht ein Aktenschrank und dahinter erkennst du im Schatten eine weitere Gestalt.\n>Aktenschrank untersuchen\t\t\t(akten)\n>Dr. Schmidt ansprechen\t\t\t\t(schmidt)\n>Cornwall ansprechen\t\t\t\t(cornwall)\n>schattenhafte Gestalt ansprechen\t\t(schatten)\n>Raum verlassen\t\t\t\t\t(raus)\n");
		textsByName.put("a6","Der Schrank ist relativ leer. Die Akten beschreiben vorbildliche Mitarbeiter, die allesamt einen grossen Beitrag zur Entwicklung MediTechs beigetragen haben. Besonders ins Auge f�llt dir eine Akte deren Inhalt gr�ssten Teils herausgeschw�rzt wurde, als w�re sie zensiert. Auf einer Seite erkennst du noch den Namen John Dahl.\n");
		textsByName.put("smt","Dr. Schmidt. Derzeitige Ober�rztin der MediTech Institution am Standort Finkenau. Habe ein neues System zur Verwaltung und Auswertung von Patientendaten entwickelt. Sehr gesch�tzte Mitarbeiterin.\"\n");
		textsByName.put("ceo","\"Ich bin Max Cornwall, der Kopf von MediTech. Nur ich kenne das Passwort zum zentralen Serverraum.\n Aber solange du unbewaffnet bist werde ich nicht gegen dich k�mpfen.\"");
		textsByName.put("dahl","\"John Dahl. Ehemaliger Mitarbeiter von MediTech. XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX\"\n");
		textsByName.put("r3","Du stehst vor einer etwas sch�bigen T�r. In leicht verblasster Schrift steht darauf \"Abstellraum\".\n>T�r �ffnen\t(auf)\n>zur�ck gehen\t(zurueck)\n");
		textsByName.put("r3A","Du findest dich in einem kleinen Kabuff wieder. Zu deiner linken steht ein gew�hnlicher Schrank, rechts ein alter Spind und vor dir ein abgenutzter Tisch. In der gegen�berliegenden Ecke steht eine Werkbank.\n>Schrank �ffnen\t\t(schrank)\n>Spind �ffnen\t\t(spind)\n>Tisch untersuchen\t(tisch)\n>Werkbank n�her ansehen\t(werkbank)\n>zur�ck in den Flur\t(zurueck)\n");
		textsByName.put("r3B","Zu deiner linken steht ein gew�hnlicher Schrank, rechts ein alter Spind und vor dir ein abgenutzter Tisch. In der gegen�berliegenden Ecke steht eine Werkbank.\n>Schrank �ffnen\t\t(schrank)\n>Spind �ffnen\t\t(spind)\n>Tisch untersuchen\t(tisch)\n>Werkbank n�her ansehen\t(werkbank)\n>zur�ck in den Flur\t(zurueck)\n");
		textsByName.put("sr","Der Schrank enth�lt diverse Putzmittel und einige schmuddelige Lappen.\n");
		textsByName.put("sp","Auf dem Boden des Spinds steht ein Eimer mit einem Mopp.\n");
		textsByName.put("t","Auf dem Tisch liegen eine halbleere Schachtel Zigaretten, ein Feuerzeug und etwas Kleingeld.\n>Geld n�her ansehen\t(geld)\n>Feuerzeug testen\t(feuer)\n>zur�cktreten\t\t(zurueck)\n");
		textsByName.put("g","2,34 Euro in kleinen M�nzen.\n");
		textsByName.put("f0","Ein funktionierendes Feuerzeug.\n>mitnehmen\t(nimm)\n>zur�ck legen\t(zurueck)");
		textsByName.put("f","Du steckst es ein.\n");
		textsByName.put("wb","Auf der Werkbank findest du eine Schere, einen Stein und ein Blatt Papier.\n>Schere untersuchen\t(schere)\n>Stein untersuchen\t(stein)\n>Papier n�her ansehen\t(papier)\n>Alles mitnehmen (nimm)\n>zur�cktreten\t\t(zurueck)\n");
		textsByName.put("sch","Eine spitze, silberne Schere.\n");
		textsByName.put("st", "Ein scharfkantiger, faustgro�er Stein.\n");
	    textsByName.put("pa", "Ein gew�hnliches, wei�es Blatt Papier.\n");
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


