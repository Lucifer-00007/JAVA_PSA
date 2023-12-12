package snippet;

public class Snippet {
	@RequestMapping("/getAllReg")
	public String getAllRegistration(Model model){
		List<Registration> allRegistration = registrationService.getAllRegistration();
		System.out.println(allRegistration);
		
		model.addAttribute("allRegistration", allRegistration);
		return "list_registrations";
	}
}

