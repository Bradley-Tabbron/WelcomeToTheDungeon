package welcometothedungeon;

import java.util.Random;
import java.util.Scanner;

public class WTTDmain {

	public static void main(String[] args) {
	 Monsters slime= new Monsters("Slime",2);
	 Monsters ghost= new Monsters("Ghost",5);
	 Monsters magician= new Monsters("Magician",8);
	 Monsters dragon= new Monsters("Dragon",10);
Monsters[] monarr= {slime,slime,slime,slime,ghost,ghost,ghost,magician,magician,dragon};
Player player= new Player(40);
System.out.println("Welcome To The Dungeon");
int monnum=4;
int x=0;
Scanner sc= new Scanner(System.in);
while(x==0) {
System.out.print("There are "+monnum+" monsters in the dungeon. Care to add another? (y/n)");
String ans = sc.nextLine();
if (ans.matches("y")) {
	monnum=monnum+1;
	if(monnum==10) {
		System.out.println("The dungeon is full of monsters. Good luck. You'll need it!");
		x=1;	}
}
else {	x=1;	}
}

System.out.println("You Enter The Dungeon...");
String a = sc.nextLine();
for(int i=monnum;i>0;i--) {
	Random rand = new Random();
	int mon = rand.nextInt(10);
	Image2ASCII image2ascii = new Image2ASCII(); 
	image2ascii.LoadImage("C:\\Users\\Bradley\\Documents\\eclipsey2\\ASCIIconv\\src\\dq"+monarr[mon].name+".jpg");
	image2ascii.print();
	System.out.println("You Encounter A "+monarr[mon].name);
	String a1 = sc.nextLine();
	System.out.println("The "+monarr[mon].name+" Attacks!");
	String a2 = sc.nextLine();
	System.out.println("You Take "+monarr[mon].strength+" Points Of Damage!");
	String a3 = sc.nextLine();
	player.health=player.health-monarr[mon].strength;
	if(player.health <=0) {
		System.out.println("You Have Been Slain By The "+monarr[mon].name+" And Are Dead!");
		String a4 = sc.nextLine();
		System.out.println("Game Over");
		String a5 = sc.nextLine();
		i=0;
	}
	else {
		System.out.println("You Defeat The "+monarr[mon].name+" And Gain "+monarr[mon].strength+" EXP");
		String a6 = sc.nextLine();
		player.exp=player.exp+monarr[mon].strength;
		if(i==1) {
		System.out.println("You Bravely Vanquished All The Monsters In The Dungeon!");
		String a7 = sc.nextLine();
		System.out.println("Your Total EXP gain was "+player.exp+"!");
		String a8 = sc.nextLine();
		System.out.println("Perhaps You Could Be Even More Courageous On Your Next Quest...");
		String a9 = sc.nextLine();
		}
		else {
			System.out.println("You Continue Deeper Into The Dungeon");	
			String a10 = sc.nextLine();
		}
	}
	
}
System.out.println("Thank You For Playing");
sc.close();

}}
