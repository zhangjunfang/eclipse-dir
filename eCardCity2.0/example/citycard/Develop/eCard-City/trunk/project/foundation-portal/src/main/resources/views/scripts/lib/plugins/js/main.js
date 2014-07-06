$(function() {
    // 点击标题排序
    $('table thead th a.sort').on('click', function() {
        var self = $(this);
        var i_class = $('i', self).attr('class');
        $('table thead th a.sort i').removeClass('icon-caret-up').removeClass('icon-caret-down');

        if (i_class == 'icon-caret-down') {
            $('i', self).removeClass('icon-caret-down').addClass('icon-caret-up');
        }
        else {
            $('i', self).removeClass('icon-caret-up').addClass('icon-caret-down');
        }
        return false;
    })

    // table行选中
    $('body').on('click', '.table-single > tbody > tr',function() {
        var self_tr = $(this);
        if (self_tr.hasClass('selected_tr')) {
            self_tr.removeClass('selected_tr');
            return;
        }

        self_tr.parent().find('tr').removeClass('selected_tr');
        self_tr.addClass('selected_tr');
    })

    $('body').on('click','.table-double > tbody > tr', function() {
        var self_tr = $(this);
        if (self_tr.hasClass('selected_tr')) {
            self_tr.removeClass('selected_tr');
            return;
        }
        self_tr.addClass('selected_tr');
    })
    
    //移除table的一行
    $('body').on('click', '.remove_tr', function(){
        $(this).parent().parent().remove();
    })
})