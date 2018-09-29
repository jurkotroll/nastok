// Compiled by ClojureScript 1.10.238 {}
goog.provide('cljs.repl');
goog.require('cljs.core');
goog.require('cljs.spec.alpha');
cljs.repl.print_doc = (function cljs$repl$print_doc(p__35958){
var map__35959 = p__35958;
var map__35959__$1 = ((((!((map__35959 == null)))?(((((map__35959.cljs$lang$protocol_mask$partition0$ & (64))) || ((cljs.core.PROTOCOL_SENTINEL === map__35959.cljs$core$ISeq$))))?true:false):false))?cljs.core.apply.call(null,cljs.core.hash_map,map__35959):map__35959);
var m = map__35959__$1;
var n = cljs.core.get.call(null,map__35959__$1,new cljs.core.Keyword(null,"ns","ns",441598760));
var nm = cljs.core.get.call(null,map__35959__$1,new cljs.core.Keyword(null,"name","name",1843675177));
cljs.core.println.call(null,"-------------------------");

cljs.core.println.call(null,[cljs.core.str.cljs$core$IFn$_invoke$arity$1((function (){var temp__5457__auto__ = new cljs.core.Keyword(null,"ns","ns",441598760).cljs$core$IFn$_invoke$arity$1(m);
if(cljs.core.truth_(temp__5457__auto__)){
var ns = temp__5457__auto__;
return [cljs.core.str.cljs$core$IFn$_invoke$arity$1(ns),"/"].join('');
} else {
return null;
}
})()),cljs.core.str.cljs$core$IFn$_invoke$arity$1(new cljs.core.Keyword(null,"name","name",1843675177).cljs$core$IFn$_invoke$arity$1(m))].join(''));

if(cljs.core.truth_(new cljs.core.Keyword(null,"protocol","protocol",652470118).cljs$core$IFn$_invoke$arity$1(m))){
cljs.core.println.call(null,"Protocol");
} else {
}

if(cljs.core.truth_(new cljs.core.Keyword(null,"forms","forms",2045992350).cljs$core$IFn$_invoke$arity$1(m))){
var seq__35961_35983 = cljs.core.seq.call(null,new cljs.core.Keyword(null,"forms","forms",2045992350).cljs$core$IFn$_invoke$arity$1(m));
var chunk__35962_35984 = null;
var count__35963_35985 = (0);
var i__35964_35986 = (0);
while(true){
if((i__35964_35986 < count__35963_35985)){
var f_35987 = cljs.core._nth.call(null,chunk__35962_35984,i__35964_35986);
cljs.core.println.call(null,"  ",f_35987);


var G__35988 = seq__35961_35983;
var G__35989 = chunk__35962_35984;
var G__35990 = count__35963_35985;
var G__35991 = (i__35964_35986 + (1));
seq__35961_35983 = G__35988;
chunk__35962_35984 = G__35989;
count__35963_35985 = G__35990;
i__35964_35986 = G__35991;
continue;
} else {
var temp__5457__auto___35992 = cljs.core.seq.call(null,seq__35961_35983);
if(temp__5457__auto___35992){
var seq__35961_35993__$1 = temp__5457__auto___35992;
if(cljs.core.chunked_seq_QMARK_.call(null,seq__35961_35993__$1)){
var c__4319__auto___35994 = cljs.core.chunk_first.call(null,seq__35961_35993__$1);
var G__35995 = cljs.core.chunk_rest.call(null,seq__35961_35993__$1);
var G__35996 = c__4319__auto___35994;
var G__35997 = cljs.core.count.call(null,c__4319__auto___35994);
var G__35998 = (0);
seq__35961_35983 = G__35995;
chunk__35962_35984 = G__35996;
count__35963_35985 = G__35997;
i__35964_35986 = G__35998;
continue;
} else {
var f_35999 = cljs.core.first.call(null,seq__35961_35993__$1);
cljs.core.println.call(null,"  ",f_35999);


var G__36000 = cljs.core.next.call(null,seq__35961_35993__$1);
var G__36001 = null;
var G__36002 = (0);
var G__36003 = (0);
seq__35961_35983 = G__36000;
chunk__35962_35984 = G__36001;
count__35963_35985 = G__36002;
i__35964_35986 = G__36003;
continue;
}
} else {
}
}
break;
}
} else {
if(cljs.core.truth_(new cljs.core.Keyword(null,"arglists","arglists",1661989754).cljs$core$IFn$_invoke$arity$1(m))){
var arglists_36004 = new cljs.core.Keyword(null,"arglists","arglists",1661989754).cljs$core$IFn$_invoke$arity$1(m);
if(cljs.core.truth_((function (){var or__3922__auto__ = new cljs.core.Keyword(null,"macro","macro",-867863404).cljs$core$IFn$_invoke$arity$1(m);
if(cljs.core.truth_(or__3922__auto__)){
return or__3922__auto__;
} else {
return new cljs.core.Keyword(null,"repl-special-function","repl-special-function",1262603725).cljs$core$IFn$_invoke$arity$1(m);
}
})())){
cljs.core.prn.call(null,arglists_36004);
} else {
cljs.core.prn.call(null,((cljs.core._EQ_.call(null,new cljs.core.Symbol(null,"quote","quote",1377916282,null),cljs.core.first.call(null,arglists_36004)))?cljs.core.second.call(null,arglists_36004):arglists_36004));
}
} else {
}
}

if(cljs.core.truth_(new cljs.core.Keyword(null,"special-form","special-form",-1326536374).cljs$core$IFn$_invoke$arity$1(m))){
cljs.core.println.call(null,"Special Form");

cljs.core.println.call(null," ",new cljs.core.Keyword(null,"doc","doc",1913296891).cljs$core$IFn$_invoke$arity$1(m));

if(cljs.core.contains_QMARK_.call(null,m,new cljs.core.Keyword(null,"url","url",276297046))){
if(cljs.core.truth_(new cljs.core.Keyword(null,"url","url",276297046).cljs$core$IFn$_invoke$arity$1(m))){
return cljs.core.println.call(null,["\n  Please see http://clojure.org/",cljs.core.str.cljs$core$IFn$_invoke$arity$1(new cljs.core.Keyword(null,"url","url",276297046).cljs$core$IFn$_invoke$arity$1(m))].join(''));
} else {
return null;
}
} else {
return cljs.core.println.call(null,["\n  Please see http://clojure.org/special_forms#",cljs.core.str.cljs$core$IFn$_invoke$arity$1(new cljs.core.Keyword(null,"name","name",1843675177).cljs$core$IFn$_invoke$arity$1(m))].join(''));
}
} else {
if(cljs.core.truth_(new cljs.core.Keyword(null,"macro","macro",-867863404).cljs$core$IFn$_invoke$arity$1(m))){
cljs.core.println.call(null,"Macro");
} else {
}

if(cljs.core.truth_(new cljs.core.Keyword(null,"repl-special-function","repl-special-function",1262603725).cljs$core$IFn$_invoke$arity$1(m))){
cljs.core.println.call(null,"REPL Special Function");
} else {
}

cljs.core.println.call(null," ",new cljs.core.Keyword(null,"doc","doc",1913296891).cljs$core$IFn$_invoke$arity$1(m));

if(cljs.core.truth_(new cljs.core.Keyword(null,"protocol","protocol",652470118).cljs$core$IFn$_invoke$arity$1(m))){
var seq__35965_36005 = cljs.core.seq.call(null,new cljs.core.Keyword(null,"methods","methods",453930866).cljs$core$IFn$_invoke$arity$1(m));
var chunk__35966_36006 = null;
var count__35967_36007 = (0);
var i__35968_36008 = (0);
while(true){
if((i__35968_36008 < count__35967_36007)){
var vec__35969_36009 = cljs.core._nth.call(null,chunk__35966_36006,i__35968_36008);
var name_36010 = cljs.core.nth.call(null,vec__35969_36009,(0),null);
var map__35972_36011 = cljs.core.nth.call(null,vec__35969_36009,(1),null);
var map__35972_36012__$1 = ((((!((map__35972_36011 == null)))?(((((map__35972_36011.cljs$lang$protocol_mask$partition0$ & (64))) || ((cljs.core.PROTOCOL_SENTINEL === map__35972_36011.cljs$core$ISeq$))))?true:false):false))?cljs.core.apply.call(null,cljs.core.hash_map,map__35972_36011):map__35972_36011);
var doc_36013 = cljs.core.get.call(null,map__35972_36012__$1,new cljs.core.Keyword(null,"doc","doc",1913296891));
var arglists_36014 = cljs.core.get.call(null,map__35972_36012__$1,new cljs.core.Keyword(null,"arglists","arglists",1661989754));
cljs.core.println.call(null);

cljs.core.println.call(null," ",name_36010);

cljs.core.println.call(null," ",arglists_36014);

if(cljs.core.truth_(doc_36013)){
cljs.core.println.call(null," ",doc_36013);
} else {
}


var G__36015 = seq__35965_36005;
var G__36016 = chunk__35966_36006;
var G__36017 = count__35967_36007;
var G__36018 = (i__35968_36008 + (1));
seq__35965_36005 = G__36015;
chunk__35966_36006 = G__36016;
count__35967_36007 = G__36017;
i__35968_36008 = G__36018;
continue;
} else {
var temp__5457__auto___36019 = cljs.core.seq.call(null,seq__35965_36005);
if(temp__5457__auto___36019){
var seq__35965_36020__$1 = temp__5457__auto___36019;
if(cljs.core.chunked_seq_QMARK_.call(null,seq__35965_36020__$1)){
var c__4319__auto___36021 = cljs.core.chunk_first.call(null,seq__35965_36020__$1);
var G__36022 = cljs.core.chunk_rest.call(null,seq__35965_36020__$1);
var G__36023 = c__4319__auto___36021;
var G__36024 = cljs.core.count.call(null,c__4319__auto___36021);
var G__36025 = (0);
seq__35965_36005 = G__36022;
chunk__35966_36006 = G__36023;
count__35967_36007 = G__36024;
i__35968_36008 = G__36025;
continue;
} else {
var vec__35974_36026 = cljs.core.first.call(null,seq__35965_36020__$1);
var name_36027 = cljs.core.nth.call(null,vec__35974_36026,(0),null);
var map__35977_36028 = cljs.core.nth.call(null,vec__35974_36026,(1),null);
var map__35977_36029__$1 = ((((!((map__35977_36028 == null)))?(((((map__35977_36028.cljs$lang$protocol_mask$partition0$ & (64))) || ((cljs.core.PROTOCOL_SENTINEL === map__35977_36028.cljs$core$ISeq$))))?true:false):false))?cljs.core.apply.call(null,cljs.core.hash_map,map__35977_36028):map__35977_36028);
var doc_36030 = cljs.core.get.call(null,map__35977_36029__$1,new cljs.core.Keyword(null,"doc","doc",1913296891));
var arglists_36031 = cljs.core.get.call(null,map__35977_36029__$1,new cljs.core.Keyword(null,"arglists","arglists",1661989754));
cljs.core.println.call(null);

cljs.core.println.call(null," ",name_36027);

cljs.core.println.call(null," ",arglists_36031);

if(cljs.core.truth_(doc_36030)){
cljs.core.println.call(null," ",doc_36030);
} else {
}


var G__36032 = cljs.core.next.call(null,seq__35965_36020__$1);
var G__36033 = null;
var G__36034 = (0);
var G__36035 = (0);
seq__35965_36005 = G__36032;
chunk__35966_36006 = G__36033;
count__35967_36007 = G__36034;
i__35968_36008 = G__36035;
continue;
}
} else {
}
}
break;
}
} else {
}

if(cljs.core.truth_(n)){
var temp__5457__auto__ = cljs.spec.alpha.get_spec.call(null,cljs.core.symbol.call(null,[cljs.core.str.cljs$core$IFn$_invoke$arity$1(cljs.core.ns_name.call(null,n))].join(''),cljs.core.name.call(null,nm)));
if(cljs.core.truth_(temp__5457__auto__)){
var fnspec = temp__5457__auto__;
cljs.core.print.call(null,"Spec");

var seq__35979 = cljs.core.seq.call(null,new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"args","args",1315556576),new cljs.core.Keyword(null,"ret","ret",-468222814),new cljs.core.Keyword(null,"fn","fn",-1175266204)], null));
var chunk__35980 = null;
var count__35981 = (0);
var i__35982 = (0);
while(true){
if((i__35982 < count__35981)){
var role = cljs.core._nth.call(null,chunk__35980,i__35982);
var temp__5457__auto___36036__$1 = cljs.core.get.call(null,fnspec,role);
if(cljs.core.truth_(temp__5457__auto___36036__$1)){
var spec_36037 = temp__5457__auto___36036__$1;
cljs.core.print.call(null,["\n ",cljs.core.str.cljs$core$IFn$_invoke$arity$1(cljs.core.name.call(null,role)),":"].join(''),cljs.spec.alpha.describe.call(null,spec_36037));
} else {
}


var G__36038 = seq__35979;
var G__36039 = chunk__35980;
var G__36040 = count__35981;
var G__36041 = (i__35982 + (1));
seq__35979 = G__36038;
chunk__35980 = G__36039;
count__35981 = G__36040;
i__35982 = G__36041;
continue;
} else {
var temp__5457__auto____$1 = cljs.core.seq.call(null,seq__35979);
if(temp__5457__auto____$1){
var seq__35979__$1 = temp__5457__auto____$1;
if(cljs.core.chunked_seq_QMARK_.call(null,seq__35979__$1)){
var c__4319__auto__ = cljs.core.chunk_first.call(null,seq__35979__$1);
var G__36042 = cljs.core.chunk_rest.call(null,seq__35979__$1);
var G__36043 = c__4319__auto__;
var G__36044 = cljs.core.count.call(null,c__4319__auto__);
var G__36045 = (0);
seq__35979 = G__36042;
chunk__35980 = G__36043;
count__35981 = G__36044;
i__35982 = G__36045;
continue;
} else {
var role = cljs.core.first.call(null,seq__35979__$1);
var temp__5457__auto___36046__$2 = cljs.core.get.call(null,fnspec,role);
if(cljs.core.truth_(temp__5457__auto___36046__$2)){
var spec_36047 = temp__5457__auto___36046__$2;
cljs.core.print.call(null,["\n ",cljs.core.str.cljs$core$IFn$_invoke$arity$1(cljs.core.name.call(null,role)),":"].join(''),cljs.spec.alpha.describe.call(null,spec_36047));
} else {
}


var G__36048 = cljs.core.next.call(null,seq__35979__$1);
var G__36049 = null;
var G__36050 = (0);
var G__36051 = (0);
seq__35979 = G__36048;
chunk__35980 = G__36049;
count__35981 = G__36050;
i__35982 = G__36051;
continue;
}
} else {
return null;
}
}
break;
}
} else {
return null;
}
} else {
return null;
}
}
});

//# sourceMappingURL=repl.js.map
