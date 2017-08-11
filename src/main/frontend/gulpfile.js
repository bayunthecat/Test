var gulp = require('gulp'),
    concat = require('gulp-concat');

var path = {
    build: {
        js: '../webapp/WEB-INF/assets/js'
    },
    src: {
        js: '../webapp/WEB-INF/components/**/*.js'
    }
};

gulp.task('build', function () {
    return gulp.src(path.src.js)
        .pipe(concat('all.js'))
        .pipe(gulp.dest(path.build.js));
});