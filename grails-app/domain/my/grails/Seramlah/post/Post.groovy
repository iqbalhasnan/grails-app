package my.grails.Seramlah.post

import my.grails.Seramlah.auth.Person

class Post {
    static mapWith = "mongo"
    static transients = ["author"]

    static searchable = {
        only = ["title", "dateCreated"]
        authorId index: "no", store: "yes"
    }

    String title
    String body
    Long authorId
    List<String> tags = []
    Date dateCreated

    Person getAuthor() {
        return Person.get(authorId)
    }

    static constraints = {
        title maxSize: 160
    }
}
