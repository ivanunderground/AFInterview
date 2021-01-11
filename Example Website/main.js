window.onload=function(){
//Login Functionality
    var inputID = document.getElementById("idInput");
    var inputKey = document.getElementById("keyInput");
    var inputPassword = document.getElementById("passwordInput");
    var loginButton = document.getElementById("loginButton");

    loginButton.addEventListener("click", function(){
        //const accs = fetchAccount();
        var goodLogin = false;
        for (var i = 0; i < accs.length; i++) {
            console.log(accs[i]["ID"], accs[i]["password"])
            console.log(inputID.value, inputPassword.value)
            if (inputID.value == accs[i]["ID"] && inputPassword.value == accs[i]["password"]) {
                goodLogin = true;
                window.open("./pages/User.html")
            }    
        } if (! goodLogin) {
            alert("The ID# and password combination are invalid.")
            inputID.value = '';
            inputPassword.value = '';
        }
        
    })

//Contact Support Functionality
    var supportMessage = document.getElementById("supportMessage");
    var supportEmail = document.getElementById("supportEmail");
    var supportButton = document.getElementById("supportButton");

    supportButton.addEventListener("click", function() {
        window.open("mailto:ivanundergr0undbu4n3r@gmail.com")
        console.log("Success")
    });
        
        /** Will use email.js in future
        
        var newMessage = document.createElement("list");
        newMessage.innerHTML = supportMessage.value;

        supportMessage.value = "";*/
}

//Make sure json server is running
async function fetchAccount() {
    const respJSON = [];
    const response = await fetch("http://localhost:3000/accounts", {
        method : "GET"})
        
        /**headers : { 
          'Content-Type': 'application/json',
          'Accept': 'application/json'
         } **/

        .then((resp) => resp.json());
        return response;
       
    }

var accs = [
        {
        "ID": 123,
        "password": "password",
        "invested": 10.00
        },
        {
        "ID": 456,
        "password": "password",
        "invested": 10.00
        },
        {
        "ID": 789,
        "password": "password",
        "invested": 10.00
        }]

console.log(accs)