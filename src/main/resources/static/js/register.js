
function getUsers() {
    axios(
        {
            method: "get",
            url: "/all"
        }
    )
        .then(res => console.log(res))
        .catch(err => console.log(err));
}

function addUser() {
    const username=document.getElementById("username").value;
    const password=document.getElementById("password").value;
    const email=document.getElementById("email").value;
    const firstName=document.getElementById("firstName").value;
    const lastName=document.getElementById("lastName").value;
    let data={
        username: username,
        password: password,
        email: email,
        firstName: firstName,
        lastName: lastName
    };

    let form = document.getElementById("card");
    // function handleForm(event) { event.preventDefault(); }
    // form.addEventListener('submit', handleForm);

    form.addEventListener("submit", function (event) {
        event.preventDefault();
    });


    axios.post("/api/register", data)
        .then(function (response) {
        if (response.status===200){
            location.href="/success";
            // console.log(response);
            // console.log(response.data);
        }
    })
        .catch(function (error) {
            // console.log(error)
            // console.log(error.response);
            // console.log(error.request);
            // console.log(error.response.data);
            document.getElementById("resError").innerHTML=error.response.data;
        })


    // axios({
    //     method: "post",
    //     url: "/api/register",
    //     data:{
    //         username: username,
    //         password: password
    //     }
    // })
    //     .then(res => console.log(res))
    //     .catch(err => console.log(err));
}


