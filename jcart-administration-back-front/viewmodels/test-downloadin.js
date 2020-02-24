var app = new Vue({
    el: '#app',
    data: {},
    methods: {
        handleDownloadinClick() {
            console.log('downloadin click');
            fetch('http://localhost/video/ce85a376-61a6-4cee-afb3-59e379e40dad.mp4')
                .then(resp => resp.blob())
                .then(blob => {
                    const url = window.URL.createObjectURL(blob);
                    const a = document.createElement('a');
                    a.style.display = 'none';
                    a.href = url;
                    // the filename you want
                    a.download = 'bb.mp4';
                    document.body.appendChild(a);
                    a.click();
                    window.URL.revokeObjectURL(url);
                    alert('your file has downloaded!'); // or you know, something with better UX...
                })
                .catch(() => alert('oh no!'));
        }
    }
})