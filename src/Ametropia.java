public class Ametropia {

	Symulation symulacja;

	public Ametropia(Symulation symulacja){	
		this.symulacja = symulacja;
		
	}
	
	public int setFocus (int wada)
	{
		int focos;
		double AVpowofeye = 58.64; 
		double firstfocos, focosf,powofeye;
		firstfocos = 1/AVpowofeye;
		
		if(symulacja.farSightedness.isSelected()) {  // nadwzrocznosc
		powofeye = AVpowofeye + wada;
		focosf = (firstfocos - 1/powofeye)*100000; //od tego miejsca widzi do nieskonczonosci
		}
		else {	//krotkowidz
			powofeye = AVpowofeye + wada;
			focosf = (firstfocos - 1/powofeye)*100000; // od tego miejsca nie widzi do nieskoĹ„czonoĹ›ci
		}
		focos = (int) Math.round(focosf);
		
		return focos;
		
	}
	
}
