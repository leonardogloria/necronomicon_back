package necronomicon_back


import grails.rest.*

@Resource(readOnly = false, formats = ['json', 'xml'])
class Class {
    String days
    String discipline
    String teacher
    Long amount
    static hasMany = [students: Student]
    static belongsTo = Student
    static constraints = {
        students nullable: true
    }

}