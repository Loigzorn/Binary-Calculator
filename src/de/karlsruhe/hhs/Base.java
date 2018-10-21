package de.karlsruhe.hhs;

enum Base {
	
	ONE (1),
	TWO (2),
	THREE (3),
	FOUR (4),
	FIVE (5),
	SIX (6),
	SEVEN (7),
	EIGHT (8),
	NINE (9),
	TEN (10)
	;
	
	private final int baseCode;
	
	Base(int baseCode) {
		this.baseCode = baseCode;
	}
	
	public int getBaseCode() {
        return this.baseCode;
    }

}