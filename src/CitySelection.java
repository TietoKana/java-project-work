import javax.swing.JOptionPane;

public class CitySelection {
	
	public static String selectCity() {
		String city = "Tampere";
		
		String a = JOptionPane.showInputDialog(
			null,
			"Please select one of the following cities"
			+ "\n1. Tampere"
			+ "\n2. Helsinki"
			+ "\n3. Rovaniemi"	
		);
		
		int response = Integer.parseInt( a );
		
		switch ( response  ) {
		case 1:
			city = "Tampere";
			break;
		case 2:
			city = "Helsinki";
			break;
		case 3:
			city = "Rovaniemi";
			break;
		default:
			break;
		}
		return city;
	}
}
