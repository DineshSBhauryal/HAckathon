/**
 * Created by vikalpgupta on 6/5/16.
 */

var pdpTimeDataM;
//localStorage.removeItem("myData");


(function () {
	//document.cookie="eid=\"dineshbhauryal@gmail.com\"";
    var Const = {
        MY_DATA: "myData",
        ALL_PAGE_VIEW: "allPageView",
        PDP_DATA: "pdpData",
        PDP_COUNT: "pdpCount",
        TIME_DATA: "timeData",
        URL: "url"
    };

    var pdpTimeStart, pdpTimeEnd;

    var currPathName = window.location.pathname;

    function getDataLocalStorage() {
        var dataItem = JSON.parse(window.localStorage.getItem("myData"));
        if (!dataItem) {
            window.localStorage.setItem("myData", JSON.stringify({}));
            dataItem = JSON.parse(window.localStorage.getItem("myData"));
        }

        return dataItem;
    }

    function getAllPageViewData() {
        var dataLocal = getDataLocalStorage();

        if (!dataLocal[Const.ALL_PAGE_VIEW]) {
            dataLocal[Const.ALL_PAGE_VIEW] = 0;
            window.localStorage.setItem("myData", JSON.stringify(dataLocal));
        }

        return dataLocal[Const.ALL_PAGE_VIEW];
    }

    function incSetAllPageView() {
        var allPageData = getAllPageViewData();
        var dataItem = getDataLocalStorage();

        dataItem[Const.ALL_PAGE_VIEW] = ++allPageData;

        window.localStorage.setItem("myData", JSON.stringify(dataItem));
    }

    function getPdpCheck() {
        if (window.location.pathname.startsWith("/")) {
            return true;
        }
        return false;
    }

    function getPDPViewData() {
        var dataLocal = getDataLocalStorage();

        if (!dataLocal[Const.PDP_DATA]) {
            dataLocal[Const.PDP_DATA] = [];
            window.localStorage.setItem(Const.MY_DATA, JSON.stringify(dataLocal));
        }

        return dataLocal[Const.PDP_DATA];
    }

    function findCurrPdpDataObj(pdpData) {
        var currObj;
        for (var i = 0; i < pdpData.length; i++) {
            currObj = pdpData[i];
            for (var keyName in currObj) {
                if (keyName == Const.URL && currObj[keyName] == currPathName) {
                    return currObj;
                }
            }
        }

        return undefined;
    }

    function setPdpCountData() {
        var dataLocal = getDataLocalStorage();
        var pdpData = getPDPViewData();
        var index;

        var pdpDataObj = findCurrPdpDataObj(pdpData);

        if (!pdpDataObj) {
            pdpDataObj = {};
            pdpDataObj[Const.URL] = currPathName;
            pdpDataObj[Const.PDP_COUNT] = 1;
            pdpData.push(pdpDataObj);
        } else {
            index = pdpData.indexOf(pdpDataObj);
            if (!pdpDataObj[Const.PDP_COUNT]) {
                pdpDataObj[Const.PDP_COUNT] = 0;
            }
            pdpDataObj[Const.PDP_COUNT] = ++pdpDataObj[Const.PDP_COUNT];
            pdpData[index] = pdpDataObj;
        }

        dataLocal[Const.PDP_DATA] = pdpData;

        window.localStorage.setItem(Const.MY_DATA, JSON.stringify(dataLocal));
    }

    function setPdpTimeData() {
        var dataLocal = getDataLocalStorage();
        var pdpData = getPDPViewData();
        var index;

        pdpTimeEnd = new Date().getTime();

        var pdpDataObj = findCurrPdpDataObj(pdpData);

        if (!pdpDataObj) {
            pdpDataObj = {};
            pdpDataObj[Const.URL] = currPathName;
            pdpDataObj[Const.TIME_DATA] = 0;
            pdpData.push(pdpDataObj);
        } else {
            index = pdpData.indexOf(pdpDataObj);

            if (!pdpDataObj[Const.TIME_DATA]) {
                pdpDataObj[Const.TIME_DATA] = 0;
            }
            pdpDataObj[Const.TIME_DATA] = pdpTimeEnd - pdpTimeStart;

            pdpData[index] = pdpDataObj;
        }

        dataLocal[Const.PDP_DATA] = pdpData;

        window.localStorage.setItem(Const.MY_DATA, JSON.stringify(dataLocal));
    }

    pdpTimeDataM = setPdpTimeData;

    window.onload = function () {
        incSetAllPageView();
        if (getPdpCheck()) {
            setPdpCountData();
            pdpTimeStart = new Date().getTime();

            window.onunload = function () {
                setPdpTimeData();
            }
        }
    };
})();