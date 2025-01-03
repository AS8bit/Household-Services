import { useState, useEffect } from "react";
import axios from "axios";
import { useHistory } from "react-router-dom";

function ForgotPassword() {
  const [email, setEmail] = useState("");
  const [name, setName] = useState("");

  const history = useHistory();
  const onsubmit = () => {
    console.log(email);
    const body = {
      email,
      name,
    };

    const serverURL = "http://localhost:7071/forgot";
    const url = serverURL + `/sendotp`;

    axios.post(url, body).then((response) => {
      const result = response.data;
      if (result["status"] == "success") {
        sessionStorage.setItem("otp", result["otp"]);
        sessionStorage.setItem("name", name);
        sessionStorage.setItem("email", email);
        history.push("/verifyOtp");

      } else {

      }
    });
  };

  return (
    <div className='customerlogin'>
      <br></br>

      <center>
        <br></br>
        <br></br>
        <br></br>
        <br></br>
        <br></br>
        <br></br>
        <h1 className="card card-container" style={{ background: 'rgba(255,255,255,.0)', boxShadow: '0 5px 15px rgba(0,0,0,.5)' }}>Forget Password</h1>
        <table table-border={0}>
          <br></br>

          <tr>
            <td>
              <h2 className="form-group">Name :</h2>
            </td>
            <td>
              <input
                type={"name"}
                placeholder={"Enter Name"}
                className="form-control"
                style={{ width: 300, marginLeft: 70 }}
                onChange={(e) => {
                  setName(e.target.value);
                }}
              ></input>
            </td>
          </tr>

          <tr>
            <td>
              <h2 className="form-group">Email :</h2>
            </td>
            <td>
              <input
                type={"email"}
                placeholder={"Enter Email"}
                className="form-control"
                style={{ width: 300, marginLeft: 70 }}
                onChange={(e) => {
                  setEmail(e.target.value);
                }}
              ></input>
            </td>
          </tr>
          <br></br>
          <tr>
            <td colSpan={2}>
              <center>
                <button
                  style={{ width: 200, marginLeft: 125 }}
                  className="btn btn-primary btn-block"
                  onClick={onsubmit}>Submit</button>
              </center>
            </td>
          </tr>
          <br></br>

          <br></br>
          <br></br>
          <br></br>
          <br></br>
          <br></br>
          <br></br>
          <br></br>

        </table>
      </center>
    </div>
  );
}
export default ForgotPassword;