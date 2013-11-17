package my.grails.Seramlah.auth

class Person {

    String username
    String password
    boolean accountLocked
    static hasMany = [followed:Person]
    static searchable = [only: ['username', 'realName']]

    static constraints = {
        username blank: false, unique: true
        password blank: false
    }

    static mapping = {
        password column: '`password`'
    }

    Set<Authority> getAuthorities() {
        PersonAuthority.findAllByPerson(this).collect { it.authority } as Set
    }
}
