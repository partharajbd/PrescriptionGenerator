var prescriptionCreateForm = document.getElementById("create-prescription");
if (prescriptionCreateForm) {
    prescriptionCreateForm.addEventListener("submit", function (e) {

        let containsError = false;


        let prescriptionDateInput = prescriptionCreateForm.querySelector("input[name=prescriptionDate]");
        let prescriptionDate = prescriptionDateInput.value;
        let today = new Date();
        today.setHours(23,59,59);

        if (prescriptionDate == "") {
            alert("Prescription date field is required");
            containsError = true;
        }else if(new Date(prescriptionDateInput.value) > today){
            alert("Prescription date should be today's or older date");
            containsError = true;
        }


        // Validation for other fields goes here


        if (containsError) {
            e.preventDefault();
        }
    });
}