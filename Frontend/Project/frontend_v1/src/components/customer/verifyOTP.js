import { useState } from "react";
import { useHistory } from "react-router-dom";

const VerifyOtp = () => {
  
  const history = useHistory();
  const [otp, setOtp] = useState("");

  const checkOtp = () => {
    console.log("inside checkotp");
    let data = sessionStorage.getItem("otp");
    console.log(data);
    console.log(otp);
    if (otp == data) {
      history.push("/ResetPass");
    }
  };

  return (
    
    <div  className='customerlogin'>
        <br></br>
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
      <h1  className="card card-container" style={{background:'rgba(255,255,255,.0)' , boxShadow:'0 5px 15px rgba(0,0,0,.5)', color:"white" }}>Enter The OTP</h1>
        <table >
          <tr>
            <td >
               
            </td>
            </tr>
            <tr>
            <td>
              <input
                type={"text"}
                placeholder={"Enter Valid OTP "}
                className="form-control"
                style={{ width: 300, marginLeft: 70  }}
                onChange={(e) => {
                  setOtp(e.target.value);
                }}
              ></input>
            </td>
            <td>
                <br></br>
                <br></br>
            </td>
          </tr>
          </table>
          <table>
          <tr>
            <td>
              <button onClick={checkOtp}
               style={{ width: 200, marginTop: 40 }}
               className="btn btn-primary btn-block">SendOTP</button>
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
        <br></br>
        <br></br>
        <br></br>
    </div>
  );
};

export default VerifyOtp;