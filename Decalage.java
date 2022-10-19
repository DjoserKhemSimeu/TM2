package tm2Pak;

public class Decalage extends Cryptage{

	public Decalage() {
		// TODO Auto-generated constructor stub
	}
	public Decalage(String clef) {
		this.clef=clef;
		initializeADC();
	}
	
	private static int  nbContains(char c, String s) {
		int compt=0;
		int i=0;
		while(i<s.length()) {
			if(s.charAt(i)==c) {
				compt++;
			}
			i++;
		}
		return compt;
	}
	private void initializeADC() {
		 String copy=new String();
		int i=0;
		int i2=0;
		while(i<clef.length()) {
				copy=copy+ALPHABET.charAt((ALPHABET.length())-clef.length()+i);
			i2++;
			
			i++;
		}
		i=0;
		while(i<clef.length()) {
			if(nbContains(clef.charAt(i),copy)==0) {
				copy=copy+clef.charAt(i);
				i2++;
			}
			i++;
		}
		i=0;
		while(i<ALPHABET.length()-clef.length()) {
			if(nbContains(ALPHABET.charAt(i),copy)==0) {
				copy=copy+ALPHABET.charAt(i);
				i2++;
			}
			i++;
		}
		alphabetDeCryptage=copy;
	
	}
	public String toString() {
		String s=super.toString();
		s=s+'\n'+"Transformation de Cryptage : "+alphabetDeCryptage;
		return s;
	}
	public String cryptage (String s) {
		int i=0;
		String res=new String();
		while (i<s.length()) {
			if(s.charAt(i)==' ') {
				res=res+" ";
			}else {
				res=res+alphabetDeCryptage.charAt(ALPHABET.indexOf(s.charAt(i)));
			}
			i++;
		}
		return res;
	}
	public String deCryptage(String s) {
		int i=0;
		String res=new String();
		while(i<s.length()) {
			if (s.charAt(i)==' ') {
				res=res+" ";
			}else {
				res=res+ALPHABET.charAt(alphabetDeCryptage.indexOf(s.charAt(i)));
			}
			i++;
		}
		return res;
	}
	
	public static void main(String[]args) {
		Decalage c=new Decalage("decalage");
		System.out.println(c.toString());
		System.out.println(c.cryptage("le langage java"));
	}

}

