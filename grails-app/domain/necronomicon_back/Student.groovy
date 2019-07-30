package necronomicon_back


import grails.rest.*

@Resource(readOnly = false, formats = ['json', 'xml'])
class Student {
    String name;
    String email
    String password
    String username
    String course

    static hasMany = [disciplines:Class]
    static constraints = {
        disciplines nullable: true
    }

}