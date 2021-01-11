//Works on backend, need to bridge to frontend (with browserify?)

//Contact Support Functionality
const nodemailer = require("nodemailer");

let transporter = nodemailer.createTransport({
  service: "gmail",
  auth: {
    user: "ivanundergr0undbu4n3r@gmail.com",
    pass : "X91sfde2Su"
        }
});

export default class supportEmail {
  constructor(address, message){
    this.internalMailOptions = {
      from: "ivanundergr0undbu4n3r@gmail.com",
      to: "ivanundergr0undbu4n3r@gmail.com",
      subject: "Support Request from " + address,
      text: message,
    }}

    externalMailOptions = {
      from: "ivanundergr0undbu4n3r@gmail.com",
      to: address,
      subject: "Support Request Recieved",
      text: "Your support request to Underground Investments has been recieved, we will be with you shortly."
    }

    send() {
      transporter.sendMail(this.internalMailOptions, function(err, data) {
        if (err) {
          console.log("Error, unable to send", err)
          } else console.log("Email sent!!!")
        })
      

      transporter.sendMail(this.externalMailOptions, function(err, data) {
        if (err) {
          console.log("Error, unable to send", err)
          } else console.log("Email sent!!!")
        })
      }
    }


   