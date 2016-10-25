package uk.co.senab.photoview.c;

import android.content.Context;
import android.widget.Scroller;

// compiled from: PreGingerScroller.java
public final class c extends d {
    private final Scroller a;

    public c(Context context) {
        this.a = new Scroller(context);
    }

    public final boolean a() {
        return this.a.computeScrollOffset();
    }

    public final void a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.a.fling(i, i2, i3, i4, i5, i6, i7, i8);
    }

    public final void b() {
        this.a.forceFinished(true);
    }

    public final boolean c() {
        return this.a.isFinished();
    }

    public final int d() {
        return this.a.getCurrX();
    }

    public final int e() {
        return this.a.getCurrY();
    }
}
