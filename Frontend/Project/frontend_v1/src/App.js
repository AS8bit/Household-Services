import './App.css'
import { BrowserRouter as Router, Switch, Route, Link } from 'react-router-dom'
import Register from './components/customer/Register'
import AdminLogin from './components/admin/login'
import Login from './components/customer/login'
import Home from './components/home'
import React from 'react'
import AdminPage from './components/admin/AdminPage'
import ListServiceProviderComponent from './components/admin/ListServiceProviderComponent'
import UpdateServiceProviderComponent from './components/admin/UpdateServiceProviderComponent'
import CreateServiceProviderComponent from './components/admin/CreateServiceProviderComponent'
import ViewServiceProviderComponent from './components/admin/ViewServiceProviderComponent'
import ListCustomerComponent from './components/admin/ListCustomerComponent'
import about from './components/about'
import logout from './components/logout'
import * as ReactBootStrap from "react-bootstrap"
import AllServices from './components/AllServices'
import Navigation from './components/Navigation'
import Profile from './components/customer/Profile'
import GetServices from './components/customer/GetServices'
import History from './components/customer/HistoryPage'
import ForgotPassword from './components/customer/ForgotPassword'
import VerifyOtp from '../src/components/customer/verifyOTP'
import ResetPass from './components/customer/ResetPass'

function App() {
  return (
    <div>
      <div>
     
        <Router>
        <Navigation></Navigation>
          <Switch>
            <Route exact path="/"><Home></Home></Route>
            <Route path="/register"> <Register></Register></Route>
            <Route path="/admin"><AdminLogin></AdminLogin></Route>
            <Route path="/login"><Login></Login></Route>
            <Route path="/adminpage"><AdminPage></AdminPage></Route>
              <Route path="/list-serviceprovider" exact component={ListServiceProviderComponent}></Route>
            <Route path="/list-customer" exact component={ListCustomerComponent}></Route>
            <Route path="/add-serviceprovider" component={CreateServiceProviderComponent}></Route>
            <Route path="/ForgotPassword" exact component={ForgotPassword}></Route>
            <Route path="/verifyOtp" exact component={VerifyOtp}></Route>
            <Route path="/ResetPass" exact component={ResetPass}></Route>
            <Route path="/update-serviceprovider/:id" component={UpdateServiceProviderComponent}></Route>
            <Route path="/view-serviceprovider/:id" component={ViewServiceProviderComponent}></Route>
            <Route path="/about" component={about}></Route>
            <Route path="/logout"><logout></logout></Route>
            <Route path="/allServices" component={AllServices}></Route>
            <Route path="/customer/:id" component={Profile}></Route>
            <Route path="/list-ServiceProviders/:serviceType" component={GetServices}></Route>
            <Route path="/history" component={History}></Route>
          
          </Switch>
        </Router>
      </div>
    
    </div>
  )
}


export default App
