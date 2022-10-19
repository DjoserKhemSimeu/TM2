package tm2Pak;

public class Playfair extends Cryptage{

	public Playfair() {
		// TODO Auto-generated constructor stub
	}
	public Playfair(String clef) {
		this.clef=clef;
		initializeMatrice();
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
	public void initializeMatrice() {
		 String copy=new String();
			int i=0;
			int i2=0;
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
	private int getLigne(char c) {
		return ((int)(alphabetDeCryptage.indexOf(c)/6));
	}
	private int getColonne(char c) {
		return alphabetDeCryptage.indexOf(c)%6;
	}
	
		public String toString() {
			String s=super.toString();
			s=s+'\n'+"Matrice de Cryptage : "+alphabetDeCryptage;
			return s;
		}
		public String cryptage(String s) {
			int i=0;
			String res=new String();
			if(s.length()==1) {
				return s;
			}
			while(i+1<s.length()) {
				if(alphabetDeCryptage.indexOf(s.charAt(i))==-1 ||
						alphabetDeCryptage.indexOf(s.charAt(i+1))==-1 ) {
					res=res+s.charAt(i)+s.charAt(i+1);
				}else {
					if(getLigne(s.charAt(i))==getLigne(s.charAt(i+1))&&(s.charAt(i)!=s.charAt(i+1))) {
						int a=alphabetDeCryptage.indexOf(s.charAt(i));
						int b=alphabetDeCryptage.indexOf(s.charAt(i+1));
						if(a%6==5) {
							res=res+alphabetDeCryptage.charAt(a-5);
						}else {
							res=res+alphabetDeCryptage.charAt(a+1);
						}
						if(b%6==5) {
							res=res+alphabetDeCryptage.charAt(b-5);
						}else {
							res=res+alphabetDeCryptage.charAt(b+1);
						}	
					}
					else if(getColonne(s.charAt(i))==getColonne(s.charAt(i+1))&&(s.charAt(i)!=s.charAt(i+1))) {
						int a=alphabetDeCryptage.indexOf(s.charAt(i));
						int b=alphabetDeCryptage.indexOf(s.charAt(i+1));
						if(getLigne(s.charAt(i))==5) {
							res=res+alphabetDeCryptage.charAt(a-30);
						}else {
							res=res+alphabetDeCryptage.charAt(a+6);
						}
						if(getLigne(s.charAt(i+1))==5) {
							res=res+alphabetDeCryptage.charAt(b-30);
						}else {
							res=res+alphabetDeCryptage.charAt(b+6);
						}

					}else if(s.charAt(i)==s.charAt(i+1)){
						int a=alphabetDeCryptage.indexOf(s.charAt(i));
						int b=alphabetDeCryptage.indexOf(s.charAt(i+1));
						if(getLigne(s.charAt(i))==5) {
							res=res+alphabetDeCryptage.charAt(a-30);
						}else {
							res=res+alphabetDeCryptage.charAt(a+6);
						}
						if(getLigne(s.charAt(i+1))==5) {
							res=res+alphabetDeCryptage.charAt(b-30);
						}else {
							res=res+alphabetDeCryptage.charAt(b+6);
						}

					}
					else {
						int a=getLigne(s.charAt(i))*6+getColonne(s.charAt(i+1));
						int b=getLigne(s.charAt(i+1))*6+getColonne(s.charAt(i));
						res=res+alphabetDeCryptage.charAt(a)+alphabetDeCryptage.charAt(b);
					}
					
				}
				i+=2;
				
			}
			if(s.length()%2==1) {
				res=res+s.charAt(s.length()-1);
			}
			return res;
			
		}
		public String deCryptage(String s) {
			int i=0;
			String res=new String();
			if(s.length()==1) {
				return s;
			}
			while(i+1<s.length()) {
				if(alphabetDeCryptage.indexOf(s.charAt(i))==-1 ||
						alphabetDeCryptage.indexOf(s.charAt(i+1))==-1 ) {
					res=res+s.charAt(i)+s.charAt(i+1);
				}else {
					if(getLigne(s.charAt(i))==getLigne(s.charAt(i+1))&&(s.charAt(i)!=s.charAt(i+1))) {
						int a=alphabetDeCryptage.indexOf(s.charAt(i));
						int b=alphabetDeCryptage.indexOf(s.charAt(i+1));
						if(a%6==0) {
							res=res+alphabetDeCryptage.charAt(a+5);
						}else {
							res=res+alphabetDeCryptage.charAt(a-1);
						}
						if(b%6==0) {
							res=res+alphabetDeCryptage.charAt(b+5);
						}else {
							res=res+alphabetDeCryptage.charAt(b-1);
						}	
					}
					else if(getColonne(s.charAt(i))==getColonne(s.charAt(i+1))&&(s.charAt(i)!=s.charAt(i+1))) {
						int a=alphabetDeCryptage.indexOf(s.charAt(i));
						int b=alphabetDeCryptage.indexOf(s.charAt(i+1));
						if(getLigne(s.charAt(i))==0) {
							res=res+alphabetDeCryptage.charAt(a+30);
						}else {
							res=res+alphabetDeCryptage.charAt(a-6);
						}
						if(getLigne(s.charAt(i+1))==0) {
							res=res+alphabetDeCryptage.charAt(b+30);
						}else {
							res=res+alphabetDeCryptage.charAt(b-6);
						}

					}else if(s.charAt(i)==s.charAt(i+1)){
						int a=alphabetDeCryptage.indexOf(s.charAt(i));
						int b=alphabetDeCryptage.indexOf(s.charAt(i+1));
						if(getLigne(s.charAt(i))==0) {
							res=res+alphabetDeCryptage.charAt(a+30);
						}else {
							res=res+alphabetDeCryptage.charAt(a-6);
						}
						if(getLigne(s.charAt(i+1))==0) {
							res=res+alphabetDeCryptage.charAt(b+30);
						}else {
							res=res+alphabetDeCryptage.charAt(b-6);
						}

					}
					else {
						int a=getLigne(s.charAt(i))*6+getColonne(s.charAt(i+1));
						int b=getLigne(s.charAt(i+1))*6+getColonne(s.charAt(i));
						res=res+alphabetDeCryptage.charAt(a)+alphabetDeCryptage.charAt(b);
					}
					
				}
				
				i+=2;
				
			}
			if(s.length()%2==1) {
				res=res+s.charAt(s.length()-1);
			}
			return res;
			
		}
		public static void main(String[]args) {
			Playfair p=new Playfair("playfair");
			System.out.print(p.deCryptage("fb lfkcirg jfta"));
		}
		
		

}
