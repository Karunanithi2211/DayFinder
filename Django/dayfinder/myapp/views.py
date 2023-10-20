from django.shortcuts import render


def Home(reqest):
    return render(reqest,'dayfind.html')

def dayFind(request):
    if request.method=='POST':
        date = int(request.POST['date'])
        month = request.POST['month']
        year = int(request.POST['year'])
        monthss={
            'jan':"January",
            'feb':"February",
            'mar':"March",
            'apr':"April",
            'may':"May",
            'june':"June",
            'july':"July",
            'aug':"August",
            'sep':"September",
            'oct':"October",
            'nov':"November",
            'dec':"December",
        }
        msgmonth = monthss[month]
        message = f"The day for {date}/{msgmonth}/{year} is"
        months = {
            'jan':0,
            'feb':3,
            'mar':3,
            'apr':6,
            'may':1,
            'june':4,
            'july':6,
            'aug':2,
            'sep':5,
            'oct':0,
            'nov':3,
            'dec':5,
        }
        days = {
            '-1':'Saturday',
            '0':'Sunday',
            '1':'Monday',
            '2':'Tuesday',
            '3':'Wednesday',
            '4':'Thursday',
            '5':'Friday',
            '6':'Saturday',
        }
        def value(year):
            if (year>=1600 and year<=1699) or (year>=2000 and year<=2099):
                return 6
            if year>=1700 and year<=1799:
                return 2
            if year>=1800 and year<=1899:
                return 4
            if year>=1900 and year<=1999:
                return 0

        step1 = int(str(year)[2:])
        step2 = step1//4
        step3 = date
        step4 = int(months[month])
        step5 = value(year)
        step6 = step1+step2+step3+step4+step5
        step7 = str(step6%7)

        def is_leap_year(year):
            if ((year % 4 == 0 and year % 100 != 0) or (year % 400 == 0)) and (month == "jan" or month == 'feb'):
                return 1
            else:
                return 0
            
        if is_leap_year(year) == 1:
            step7 = str(int(step7)-1)
            day= days[step7]
            return render(request,'dayfind.html',{"day":day,"message":message})
        else:
            day = days[step7]
            return render(request,'dayfind.html',{"day":day,"message":message})
    else:
        return render(request,'dayfind.html')
