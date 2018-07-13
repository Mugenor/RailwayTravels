adminApp.directive('containedIn', function () {
    return {
        restrict: 'A',
        require: 'ngModel',
        link: function (scope, element, attr, ngModel) {
            ngModel.$validators.containedIn = function (modelValue, viewValue) {
                let list = scope[attr.containedIn];
                console.log(list);
                if(list) {
                    return list.includes(viewValue);
                }
            }
        }
    }
});