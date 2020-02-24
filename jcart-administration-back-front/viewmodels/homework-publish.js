var app = new Vue({
    el: '#app',
    data: {
        courses: [],
        selectedCourseId: '',
        selectedCourseUnit: '',
        clazzes: [],
        selectedClazzId: '',
        teachers: [],
        selectedTeacherId: '',
        deadTime: '',
        abstractContent: '',
        selectedAttatchments: [],
        attatchmentsUrls: [],
        count: 0
    },
    mounted() {
        console.log('view mounted');
        this.getAllCourse();
        this.getAllClazz();
        this.getAllTeacher();
    },
    methods: {
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
        handlePublishClick() {
            console.log('publish click');
            this.doHomeworkPublish();
        },
        doHomeworkPublish() {
            axios.post('http://localhost:8080/homework/publish', {
                courseId: this.selectedCourseId,
                courseUnit: this.selectedCourseUnit,
                teacherId: this.selectedTeacherId,
                clazzId: this.selectedClazzId,
                deadTime: this.deadTime.getTime(),
                abstractContent: this.abstractContent,
                attatchments: this.attatchmentsUrls
            })
                .then(function (response) {
                    console.log(response);
                    alert('发布成功');
                    location.href = 'dohomework-index.html';
                })
                .catch(function (error) {
                    console.error(error);
                    alert('发布失败');
                });
        },
        handleUploadClick() {
            console.log('upload click');
            this.$refs.upload.submit();
        },
        doAttatchmentUpload() {
            if (this.count > 1) {
                this.count--;
                console.log(this.count);
                return;
            }

            var formData = new FormData();
            this.selectedAttatchments.forEach(attatchment => {
                formData.append("attatchment", attatchment);
            });
            axios.post('http://localhost:8080/attatchment/upload', formData, {
                headers: {
                    'Content-Type': 'multipart/form-data'
                }
            })
                .then(function (response) {
                    console.log(response);
                    app.attatchmentsUrls = response.data;
                    alert('上传成功');
                })
                .catch(function (error) {
                    console.log(error);
                    alert('上传失败');
                });
        },
        handleOnChange(val) {
            console.log(val);
            this.selectedAttatchments.push(val.raw);
            this.count++;
            console.log(this.count);
        }
    }
})