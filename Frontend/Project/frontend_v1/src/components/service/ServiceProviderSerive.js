import axios from 'axios'

const SERVICEPROVIDER_API_BASE_URL = 'http://localhost:7071/admin'

class ServiceProviderSerive {
  getServiceproviders() {
    return axios.get(SERVICEPROVIDER_API_BASE_URL + '/AllVendors')
  }

  createServiceprovider(vendor) {
    return axios.post(SERVICEPROVIDER_API_BASE_URL + '/AddVendor', vendor)
  }

  getServiceproviderById(serviceproviderId) {
    return axios.get(
      SERVICEPROVIDER_API_BASE_URL + '/AllVendors/' + serviceproviderId
    )
  }

  updateServiceProvider(serviceprovider, serviceproviderId) {
    return axios.put(
      SERVICEPROVIDER_API_BASE_URL + '/' + serviceproviderId,
      serviceprovider
    )
  }



  deleteServiceprovider(serviceproviderId) {
    return axios.delete(SERVICEPROVIDER_API_BASE_URL + '/' + serviceproviderId)
  }

  getcustomers() {
    return axios.get(SERVICEPROVIDER_API_BASE_URL + '/AllCustomers')
  }

  getCustomerById(customerId) {
    return axios.get(
      SERVICEPROVIDER_API_BASE_URL + '/AllCustomers/' + customerId
    )
  }

  deleteCustomer(customerId) {
    return axios.delete(
      SERVICEPROVIDER_API_BASE_URL + '/customer/' + customerId
    )
  }

  getServiceByServiceType(serviceType) {
    return axios.get('http://localhost:7071/provider/' + serviceType)
  }

  bookService(vendorId) {
    console.log('in bookService in service folder!')
    const customer = JSON.parse(window.sessionStorage.getItem('user'))
    console.log('in bookService in service folder!', customer)
    console.log('in bookService in service folder!', customer.id)
    const customerId = customer.id
    const body = {
      customerId,
      vendorId,
    }
    console.log('Body:', body)
    return axios.post('http://localhost:7071/book', body)
  }


  getHistory(custId) {
    return axios.get('http://localhost:7071/History/' + custId)
  }

}

export default new ServiceProviderSerive()
