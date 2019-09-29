package com.online.bloodbank.enums;

public enum BloodGroup {
	A_PLUS("A+"), B_PLUS("B+"), AB_PLUS("AB+"), O_PLUS("O+"), A_MINUS("A-"), B_MINUS("B-"), AB_MINUS("AB-"),
	O_MINUS("O-");

	private String bloodGroupType;

	// enum constructor - cannot be public or protected
	private BloodGroup(final String bloodGroupType) {
		this.bloodGroupType = bloodGroupType;
	}

	public String getBloodGroupType() {
		return bloodGroupType;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	public static BloodGroup fromValue(final String text) {
		for (final BloodGroup b : BloodGroup.values()) {
			if (String.valueOf(b.bloodGroupType).equalsIgnoreCase(text)) {
				return b;
			}
		}
		return null;
	}

}
