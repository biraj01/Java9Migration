package com.biraj.appointmentBookingJava9.helper;

public class AppointmentUrl {
	/**
	 * Url um neue Beratungtermin anzulegen.
	 */
	public static final String createAppointment = "/students/{studentId}/appointment";

	/**
	 * Url um angelegte Beratungtermin zu löschen.
	 */
	public static final String deleteAppointment = "/students/{studentId}/appointments/{appointmentId}";
	/**
	 * Listet alle Termine an einem Tag.
	 */
	public static final String listAppointments = "counselors/{counselorId}/appointments";

	/**
	 * Verschiebt einen Termin.
	 */
	public static final String updateAppoitnment = "/counselor/{counselorId}/appointments/{appointmentId}";

}
