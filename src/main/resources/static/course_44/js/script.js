$(document).ready(function () {

    var events = []; // 存储订单数据的数组
    var memberId = 2;
    // 从后端获取数据
    $.ajax({
        url: '/frontend_courseOrder/orderList/' + memberId,
        method: 'GET',
        success: function (data) {
            // 将数据转换为适合的格式并存储在 events 数组中
            events = data.map(function (order) {
                return {
                    title: order.period.courseName + ' (' + order.period.coach + ')',
                    start: order.courseOrderBe,
                    end: order.courseOrderEn,
                    allDay: false
                };
            });

            // 更新日历的事件源
            $('#calendar').fullCalendar('removeEventSources');
            $('#calendar').fullCalendar('addEventSource', events);
            $('#calendar').fullCalendar('rerenderEvents');
        },
        error: function (error) {
            console.log('Error:', error);
        }
    })


    // 初始化日曆
    $('#calendar').fullCalendar({
        header: {
            left: 'prev,next today',
            center: 'title',
            right: 'month,agendaWeek,agendaDay'
        },
        defaultView: 'agendaWeek',
        editable: false,
        events: events.map(function (event) {
            return {
                title: event.title + ' (' + event.coach + ')',
                start: event.start,
                end: event.end,
                allDay: false
            };
        }),
        eventRender: function (event, element) {
            // 在事件右側添加取消按鈕
            var cancelBtn = $('<button>').text('取消').addClass('btn btn-danger btn-sm');
            cancelBtn.click(function () {
                if (confirm('確定要取消報名此課程嗎？')) {
                    cancelEvent(event);
                    $(this).closest('.fc-event').remove(); // 從日曆中移除事件
                }
            });
            element.find('.fc-content').append(cancelBtn);

            // 根據課程開始時間設置時間段標籤
            var timeLabel = '';
            var startTime = moment(event.start);
            var hour = startTime.hours();
            if (hour >= 9 && hour < 12) {
                timeLabel = '早';
            } else if (hour >= 14 && hour < 17) {
                timeLabel = '中';
            } else if (hour >= 18 && hour < 21) {
                timeLabel = '晚';
            }
            element.find('.fc-content').prepend('<div class="event-time-label">' + timeLabel + '</div>');
        }
    })

    // 取消課程的函數
    function cancelEvent(event) {
        // 在這裡添加取消課程的相關
        var index = events.findIndex(function (e) {
            return e.start === event.start && e.end === event.end;
        });
        if (index !== -1) {
            events.splice(index, 1); // 從課表資料中移除該課程
        }
    }
})
;