package com.xunlei.downloadprovider.search.ui.home;

import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.xunlei.downloadprovider.model.protocol.report.ThunderReporter.Sniff.SniffStartFrom;
import com.xunlei.downloadprovider.model.protocol.report.ThunderReporter.f;
import com.xunlei.downloadprovider.search.bean.d;
import com.xunlei.downloadprovider.util.c.a;
import com.xunlei.downloadprovider.web.BrowserUtil;
import com.xunlei.downloadprovider.web.BrowserUtil.StartFromType;
import com.xunlei.xllib.R;

// compiled from: HotSearchFixFragment.java
final class b implements OnItemClickListener {
    final /* synthetic */ HotSearchFixFragment a;

    b(HotSearchFixFragment hotSearchFixFragment) {
        this.a = hotSearchFixFragment;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        d dVar = (d) this.a.e.getItem(i);
        if (TextUtils.isEmpty(dVar.a())) {
            this.a.a("search_his", dVar.a);
            f.c("histroy", "word", dVar.a);
            return;
        }
        boolean z;
        String str = dVar.a + " " + dVar.a();
        HotSearchFixFragment hotSearchFixFragment = this.a;
        SniffStartFrom sniffStartFrom = SniffStartFrom.search_hot_wait;
        if (a.f(str)) {
            z = false;
        } else {
            com.xunlei.downloadprovider.search.a.a.a().a(str);
            z = true;
        }
        BrowserUtil.a();
        BrowserUtil.a(hotSearchFixFragment.getActivity(), R.styleable.Toolbar_logoDescription, str, true, StartFromType.sniff_search_result_page, z, sniffStartFrom);
    }
}
