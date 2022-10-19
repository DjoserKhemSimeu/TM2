package tm2Pak;

public abstract class Cryptage {
	 final static String ALPHABET = "abcdefghijklmnopqrstuvwxyz0123456789";
	 protected String alphabetDeCryptage;
	 protected String clef;
	 public Cryptage(){
	 };
	 public Cryptage(String clef) {
		 this.clef=clef;
	 };
	 public String toString(){
		 return (new String("Cryptage "+this.getClass().getSimpleName()+'\n'+"Mot clef "+clef));
	 };
	 public abstract String cryptage(String s);
	 public abstract String deCryptage(String s);
	 
	}
///abcdefghijklmnopqrstuvwxyz
///decalgbfghij...
///stuvwxyzdecalgfghi