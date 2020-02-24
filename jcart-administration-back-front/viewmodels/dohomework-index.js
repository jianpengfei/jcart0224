var app = new Vue({
    el: '#app',
    data: {
        pageInfo: '',
        courses: [],
        selectedCourseId: '',
        selectedCourseUnit: '',
        clazzes: [],
        selectedClazzId: '',
        teachers: [],
        selectedTeacherId: '',
        deadTime: '',
        pageNum: 1

    },
    computed: {
        deadTimestamp() {
            return this.deadTime ? this.deadTime.getTime() : '';
        }
    },
    mounted() {
        console.log('view mounted');
        this.getAllCourse();
        this.getAllClazz();
        this.getAllTeacher();
        this.search();
    },
    methods: {
        search() {
            axios.get('http://localhost:8080/dohomework/search', {
                params: {
                    courseId: this.selectedCourseId,
                    courseUnit: this.selectedCourseUnit,
                    clazzId: this.selectedClazzId,
                    teacherId: this.selectedTeacherId,
                    deadTimestamp: this.deadTimestamp,
                    pageNum: this.pageNum
                }
            })
                .then(function (response) {
                    console.log(response);
                    app.pageInfo = response.data;
                })
                .catch(function (error) {
                    console.log(error);
                });
        },
        handleCurrentChange(val) {
            console.log(val);
            this.pageNum = val;
            this.search();
        },
        getAllCourse() {
            axios.get('http://localhost:8080/course/getAll')
                .then(function (response) {
                    console.log(response);
                    app.courses = response.data;
                })
                .catch(function (error) {
                    console.log(error);
                });
        },
        getAllClazz() {
            axios.get('http://localhost:8080/clazz/getAll')
                .then(function (response) {
                    console.log(response);
                    app.clazzes = response.data;
                })
                .catch(function (error) {
                    console.log(error);
                });
        },
        getAllTeacher() {
            axios.get('http://localhost:8080/teacher/getAll')
                .then(function (response) {
                    console.log(response);
                    app.teachers = response.data;
                })
                .catch(function (error) {
                    console.log(error);
                });
        },
        handleSearchClick(){
            console.log('search click');
            this.pageNum = 1;
            this.search();
        },
        handleClearClick(){
            console.log('clear click');
            this.selectedCourseId =  '';
            this.selectedCourseUnit = '';
            this.selectedClazzId = '';
            this.selectedTeacherId = '';
            this.deadTime = '';
        },
        handleToSubmitClick(row){
            console.log('to submit click', row);
            location.href = 'dohomework-submit.html?doHomeworkId=' + row.doHomeworkId;
        },
        onSubmit(){
            location.href = 'dohomework-pinglun.html?doHomeworkId=' + row.doHomeworkId;
        }
    }
})