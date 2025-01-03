import { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router";
import { useHistory } from "react-router-dom";

const ResetPass = () => {

  const history = useHistory();
  const [password, setNewPass] = useState("");
  const [reEnterPass, setEnterPass] = useState("");

  const RequestForReset = () => {
    let email = sessionStorage.getItem("email");
    console.log(password);
    console.log(email);
    const body = {
      email,
      password,
    };

    if (password == reEnterPass) {
      console.log(body);
      const serverURL = "http://localhost:7071/forgot";
      const url = serverURL + `/resetPassword`;
      axios.post(url, body).then((response) => {
        const result = response.data;
        if (result["status"] == "success") {

          history.push("/login");
          window.location.reload();

        } else {

        }
      });
    }
  };

  return (
    <div className='customerlogin' style={{

      alignItems: 'center',
      justifyContent: 'center'

    }} >
      <br></br>
      <br></br>
      <br></br>
      <br></br>
      <br></br>
      <br></br>
      <br></br>
      <br></br>
      <br></br>



      <center>
        <h4 className="card card-container" style={{ background: 'rgba(255,255,255,.0)', boxShadow: '0 5px 15px rgba(0,0,0,.5)', color: "white" }}> Enter new  Password </h4>


        <table>
          <tr>
            <td>
              <input
                type={"password"}
                placeholder={"Enter New Password "}
                className="form-control"
                style={{ width: 300 }}
                onChange={(e) => {
                  setNewPass(e.target.value);
                }}
              ></input>
            </td>
          </tr>
        </table>

        <h4 className="card card-container" style={{ background: 'rgba(255,255,255,.0)', boxShadow: '0 5px 15px rgba(0,0,0,.5)', color: "white" }}>Re-Enter Password </h4>

        <table>

          <tr>
            <td>
              <input
                type={"password"}
                placeholder={"Confirm Password "}
                className="form-control"
                style={{ width: 300 }}
                onChange={(e) => {
                  setEnterPass(e.target.value);
                }}
              ></input>
            </td>
          </tr>

        </table>

        <table>
          <tr>
            <br></br><td>
              <button onClick={RequestForReset}
                style={{ width: 200, marginTop: 30 }}
                className="btn btn-primary btn-block">Reset</button>
            </td>
          </tr>

        </table>
      </center>

      <br></br>
      <br></br>
      <br></br>
      <br></br>
      <br></br>
      <br></br>
      <br></br>
      <br></br>
      <br></br>
    </div>
  );
};

export default ResetPass;