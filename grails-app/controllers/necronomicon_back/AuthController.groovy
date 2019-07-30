package necronomicon_back


import grails.rest.*
import grails.converters.*
import model.AuthVO
import model.UserVO

import grails.gorm.transactions.*

@Transactional
class AuthController {
	static responseFormats = ['json', 'xml']

    def index() {
        def stud = Student.get(1)
        def disciplines = Class.list().toSet()
        stud.disciplines = disciplines
        println  Student.list() as JSON

    }
    def authenticate(UserVO userVo) {
        if(userVo.password && userVo.username){
            def authedVO = new AuthVO(authed: false)
            def student = Student.findByUsernameAndPassword(userVo.username, userVo.password)
            if(student) authedVO.authed = true
            ["authed": authedVO ]

        }
    }
    @Transactional
    def addClass(){
        def alunoId = params.studentId
        def classId = params.classId

        def student = Student.get(alunoId)
        def aClass = Class.get(classId)
        student.addToDisciplines(aClass).save(flush:true)

        //render "OK" as JSON
    }
    @Transactional
    def check(){
        def alunoId = params.studentId
        def classId = params.classId
        def student = Student.get(alunoId)
        def aClass = Class.get(classId)
        println student as JSON
        println aClass as JSON

        def clazz = new Student_Class(student: student, aClass: aClass, date: new Date())
        clazz.save(flush:true)
        render  clazz as JSON


    }
    def verifyClassAmout(){
        def alunoId = params.studentId
        def classId = params.classId
        def student = Student.get(alunoId)
        def aClass = Class.get(classId)
        def presences = Student_Class.findAllByStudentAndAClass(student,aClass)
        def presencesMap = ["ammount": presences.size()]


        render presencesMap as JSON

    }
    def disciplines(Student student){
        println student as JSON

        render student.disciplines as JSON
    }
}
