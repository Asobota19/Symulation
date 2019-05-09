public class Ametropia {

	public double setFocus (int wada, boolean rodzaj)
	{
		
		double AVpowofeye = 58.64; 
		double firstfocos, focos,powofeye;
		firstfocos = 1/AVpowofeye;
		if(rodzaj == false) {  // nadwzrocznosc
		powofeye = AVpowofeye + wada;
		focos = firstfocos - 1/powofeye; //od tego miejsca widzi do nieskonczonosci
		}
		else {	//krotkowidz
			powofeye = AVpowofeye - wada;
			focos = firstfocos - 1/powofeye; // od tego miejsca nie widzi do nieskończoności
		}
		return focos*100;
		
	}
	
	
}
