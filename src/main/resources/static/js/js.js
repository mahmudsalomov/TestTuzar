function InvalidMsg(textbox) {
    if (textbox.value === '') {
        // alert("aaaaaaaaaa");
        textbox.setCustomValidity('Toʻldirish shart!');
    }


    else{


        switch (textbox.id) {



            case "qiyinlik_darajasi":
                var difficult = document.getElementById("qiyinlik_darajasi").value;
                if (difficult>10||difficult<1) {
                    // alert("Passwords do not match.");
                    document.getElementById("qiyinlik_darajasi").style.borderColor="red";
                    document.getElementById("qiyinlik_darajasi").style.color="red";
                    document.getElementById("qiyinlik_darajasi").setCustomValidity("1 va 10 oraligʻida kiriting!")
                    // return false;
                }
                else {
                    document.getElementById("qiyinlik_darajasi").style.borderColor="green";
                    document.getElementById("qiyinlik_darajasi").style.color="green";
                    document.getElementById("qiyinlik_darajasi").setCustomValidity("")
                }
                break;





            case "vaqt_qiyinlik_darajasi":
                var difficult_time = document.getElementById("vaqt_qiyinlik_darajasi").value;
                if (difficult_time>10||difficult_time<1) {
                    // alert("Passwords do not match.");
                    document.getElementById("vaqt_qiyinlik_darajasi").style.borderColor="red";
                    document.getElementById("vaqt_qiyinlik_darajasi").style.color="red";
                    document.getElementById("vaqt_qiyinlik_darajasi").setCustomValidity("1 va 10 oraligʻida kiriting!")
                    // return false;
                }
                else {
                    document.getElementById("vaqt_qiyinlik_darajasi").style.borderColor="green";
                    document.getElementById("vaqt_qiyinlik_darajasi").style.color="green";
                    document.getElementById("vaqt_qiyinlik_darajasi").setCustomValidity("")
                }
                break;







            case "difficultch":
                var difficultch = document.getElementById("difficultch").value;
                if (difficultch>10||difficultch<1) {
                    // alert("Passwords do not match.");
                    document.getElementById("difficultch").style.borderColor="red";
                    document.getElementById("difficultch").style.color="red";
                    document.getElementById("difficultch").setCustomValidity("1 va 10 oraligʻida kiriting!")
                    // return false;
                }
                else {
                    document.getElementById("difficultch").style.borderColor="green";
                    document.getElementById("difficultch").style.color="green";
                    document.getElementById("difficultch").setCustomValidity("")
                }
                break;









            case "difficult_timech":
                var difficult_timech = document.getElementById("difficult_timech").value;
                if (difficult_timech>10||difficult_timech<1) {
                    // alert("Passwords do not match.");
                    document.getElementById("difficult_timech").style.borderColor="red";
                    document.getElementById("difficult_timech").style.color="red";
                    document.getElementById("difficult_timech").setCustomValidity("1 va 10 oraligʻida kiriting!")
                    // return false;
                }
                else {
                    document.getElementById("difficult_timech").style.borderColor="green";
                    document.getElementById("difficult_timech").style.color="green";
                    document.getElementById("difficult_timech").setCustomValidity("")
                }
                break;










            default:
                textbox.setCustomValidity('');
                break;
        }


    }

    // return true;

}