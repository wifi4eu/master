var faker = require('faker')

function generateUsers () {
  var users = []

  for (var id = 1; id < 21; id++) {
    var firstName = faker.name.firstName()
    var lastName = faker.name.lastName()
    var email = faker.internet.email()
    var dateOfBirth = faker.date.between('1952-01-01','1993-01-01')

    users.push({
      "id": id,
      "firstName": firstName,
      "lastName": lastName,
      "email": email,
      "isAdmin": false,
      "dateOfBirth": dateOfBirth
    })
  }

  users[5].isAdmin = true
  users[8].isAdmin = true
  users[15].isAdmin = true

  return {
      "user-details": users[0],
      "users": users
  }
}

module.exports = generateUsers
