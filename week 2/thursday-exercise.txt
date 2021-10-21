public static void main(String[] args) {
	String[] foodTypes = getFoodTypes();
	String myType = foodTypes[2];

	String[] foodsOfMyType = getFoodsByType(myType);
	
	for (String food : foodsOfMyType) {
		System.out.println(food);
	}
}

public static String[] getFoodTypes() {
	String[] foodTypes = {"breakfast","lunch","dinner","dessert","snack"};
	return foodTypes;
}

public static String[] getFoodsByType(String type) {
	String[] foods = new String[3];

	switch(type) {
	case "breakfast":
		foods[0] = "pancakes";
		foods[1] = "cereal";
		foods[2] = "omelette";
		break;
	case "lunch":
		foods[0] = "sandwich";
		foods[1] = "salad";
		foods[2] = "soup";
		break;
	case "dinner":
		foods[0] = "curry";
		foods[1] = "stir fry";
		foods[2] = "burger";
		break;
	case "dessert":
		foods[0] = "cake";
		foods[1] = "ice cream";
		foods[2] = "candy";
		break;
	case "snack":
		foods[0] = "chips";
		foods[1] = "apple";
		foods[2] = "samosa";
		break;
	default:
		// add your own
		break;
	}

	return foods;
}