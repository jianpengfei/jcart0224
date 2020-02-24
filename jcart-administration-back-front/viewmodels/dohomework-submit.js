var app = new Vue({
    el: '#app',
    data: {
        doHomeworkId: '',
        courseName: '',
        courseUnit: '',
        clazzName: '',
        teacherName: '',
        studentName: '',
        videos: []
    },
    mounted() {
        console.log('view mounted');

        var url = new URL(location.href);
        this.doHomeworkId = url.searchParams.get("doHomeworkId");

        if (!this.doHomeworkId) {
            alert('doHomeworkId 不存在');
            return;
        }

        this.getDohomeworkById();
    },
    methods: {
        getDohomeworkById() {
            axios.get('http://localhost:8080/dohomework/getById', {
                params: {
                    doHomeworkId: this.doHomeworkId
                }
            })
                .then(function (response) {
                    console.log(response);
                    var dohomework = response.data;
                    app.courseName = dohomework.homeworkShowDTO.course.name;
                    app.courseUnit = dohomework.homeworkShowDTO.courseUnit;
                    app.clazzName = dohomework.homeworkShowDTO.clazz.name;
                    app.teacherName = dohomework.homeworkShowDTO.teacher.name;
                    app.studentName = dohomework.student.name;
                })
                .catch(function (error) {
                    console.log(error);
                });
        },
        handleUploadClick() {
            console.log('upload click');
            this.$refs.upload.submit();
        },
        handleOnSuccess(response, file, fileList) {
            console.log('on success');
            this.videos.push(response);
            alert(file.name + '上传成功');
        },
        handleSubmitClick() {
            console.log('submit click');
            this.submitDoHomework();
        },
        submitDoHomework() {
            axios.post('http://localhost:8080/dohomework/submit', {
                doHomeworkId: this.doHomeworkId,
                videos: this.videos
            })
                .then(function (response) {
                    console.log(response);
                    alert('提交成功');
                    location.href = 'dohomework-index.html';
                })
                .catch(function (error) {
                    console.error(error);
                    alert('提交失败');
                });
        }
    }
})