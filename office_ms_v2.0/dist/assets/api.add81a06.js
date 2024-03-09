import{_ as u,d as F,o as E,c as C,C as B}from"./index.faeea855.js";const a=F({setup(){}}),A={class:"layout-container"},D=B('<h1 data-v-5fbdf560>\u63A5\u53E3\u8BF4\u660E\u6587\u6863</h1><article data-v-5fbdf560><section data-v-5fbdf560><p data-v-5fbdf560>\u6709\u5F88\u591A\u5C0F\u4F19\u4F34\u5E73\u65F6\u5728\u7FA4\u91CC\u9762\u7ECF\u5E38\u4F1A\u95EE\u5230\u4E00\u4E9B\u5173\u4E8E\u9879\u76EE\u6570\u636E\u8BF7\u6C42\u7684\u95EE\u9898\uFF0C\u5728\u6B64\uFF0C\u6211\u5C31\u7EDF\u4E00\u5199\u6210\u4E00\u4E2A\u7B80\u5355\u7684\u6587\u6863\u7ED9\u5927\u5BB6\u4ECB\u7ECD\u4E00\u4E0B\u8FD9\u4E2A\u9879\u76EE\u4E2D\u4F1A\u6D89\u53CA\u5230\u7684\u54EA\u4E9B\u6570\u636E\u8BF7\u6C42\u4F7F\u7528\u7684\u65B9\u5F0F\u4F9B\u5927\u5BB6\u6765\u505A\u53C2\u8003\u3002</p><h2 style="margin-top:40px;" data-v-5fbdf560>\u6570\u636E\u8BF7\u6C42\u5C01\u88C5\u4ECB\u7ECD</h2><p data-v-5fbdf560>\u5F53\u524D\u7684\u6570\u636E\u8BF7\u6C42\u5C01\u88C5\u57FA\u4E8Eaxios\u5E93\u8FDB\u884C\u7684\u4E00\u4E2A\u5C01\u88C5\uFF0C\u4E3B\u8981\u6709\uFF1A<b data-v-5fbdf560>\u8BF7\u6C42\u524D\u7684\u516C\u5171\u5904\u7406</b>\u3001<b data-v-5fbdf560>\u8BF7\u6C42\u540E\u7684\u516C\u5171\u5904\u7406</b>\u4E24\u65B9\u9762,\u8BF7\u53C2\u7167\u6587\u4EF6\uFF1A<b data-v-5fbdf560>src/utils/system/request.ts</b></p><p data-v-5fbdf560><b data-v-5fbdf560>\u8BF7\u6C42\u524D\u7684\u516C\u5171\u5904\u7406</b></p><p data-v-5fbdf560>\u76EE\u524D\u9879\u76EE\u4E2D\u4E3B\u8981\u5BF9token\u8FDB\u884C\u4E86\u4E00\u4E2A\u524D\u7F6E\u7684\u5904\u7406\uFF0C\u7528\u6237\u53EF\u6839\u636E\u81EA\u5DF1\u7684\u4E1A\u52A1\u6765\u81EA\u884C\u6269\u5C55\uFF0C\u5982\uFF1A\u65F6\u533A\u4FE1\u606F\u3001userId\u3001\u7528\u6237\u4F4D\u7F6E\u7B49\u6570\u636E\u7684\u7EDF\u4E00\u5904\u7406\uFF0C\u5982\u679C\u5BF9\u52A0\u5BC6\u8981\u6C42\u9AD8\u7684\uFF0C\u53EF\u4EE5\u5728\u6B64\u8FDB\u884C\u8BF7\u6C42\u53C2\u6570\u52A0\u5BC6\u64CD\u4F5C\u3002</p><p data-v-5fbdf560><b data-v-5fbdf560>\u8BF7\u6C42\u540E\u7684\u516C\u5171\u5904\u7406</b></p><p data-v-5fbdf560>\u4E3B\u8981\u662F\u505A\u9519\u8BEF\u63D0\u793A\u7684\u7EDF\u4E00\u5904\u7406\uFF0C\u5F53\u6355\u6349\u5230\u9519\u8BEF\u65F6\uFF0C\u65E0\u8BBA\u662F\u6765\u81EA\u4E8E\u670D\u52A1\u5668\u7684\u9519\u8BEF\u8FD8\u662Fcode\u9519\u8BEF\uFF0C\u90FD\u5E94\u8BE5\u7EDF\u4E00\u5230\u8FD9\u91CC\u6765\u8FDB\u884C\u5904\u7406\uFF0C\u7136\u540E\u4F7F\u7528Promise\u7684catch\u8FD4\u56DE\u5230\u8C03\u7528\u4F4D\u7F6E\uFF0C\u6709\u5229\u4E8E\u5728\u590D\u6742\u4E1A\u52A1\u6A21\u578B\u4E2D\u4FDD\u6301\u9AD8\u7EF4\u62A4\u6027\u3002</p><h2 style="margin-top:40px;" data-v-5fbdf560>\u5982\u4F55\u5728\u9879\u76EE\u4E2D\u4F7F\u7528\u63A5\u53E3\u8BF7\u6C42</h2><p data-v-5fbdf560>\u54B1\u4EEC\u9700\u8981\u5173\u6CE8\u7684\u51E0\u4E2A\u5730\u65B9\u5982\u4E0B\uFF1A <ul data-v-5fbdf560><li data-v-5fbdf560>1. \u6839\u636E\u81EA\u5DF1\u4E1A\u52A1\u7C7B\u578B\u4F18\u5316\u6539\u5199: src/utils/request.ts\uFF0C\u7B80\u5355\u7684\u9879\u76EE\u53EF\u4EE5\u8DF3\u8FC7\u8FD9\u4E00\u6B65</li><li data-v-5fbdf560>2. \u6240\u6709\u7684\u63A5\u53E3\u653E\u7F6E\u7684\u6587\u4EF6\u5939\uFF1Asrc/api/*, \u54B1\u4EEC\u6240\u6709\u7684\u8BF7\u6C42\u90FD\u5E94\u8BE5\u653E\u7F6E\u4E8E\u6B64\uFF0C\u5177\u4F53\u5199\u6CD5\uFF0C\u53C2\u7167\u6587\u4EF6\u5185\u5BB9\u5373\u53EF</li><li data-v-5fbdf560>3. \u5728\u9875\u9762\u5185\u5F15\u5165\u5BF9\u5E94\u7684\u63A5\u53E3\u51FD\u6570\uFF0C\u7136\u540E\u4F7F\u7528\u5373\u53EF\uFF0C\u53EF\u4EE5\u53C2\u8003\uFF1A\u4E1A\u52A1\u8868\u683C\u6A21\u5757</li><li data-v-5fbdf560>4. \u6BCF\u6B21\u8C03\u7528\u7684\u65F6\u5019\uFF0C\u90FD\u5E94\u8BE5\u8981\u8003\u8651\u5230\u63A5\u53E3\u8FD4\u56DE\u5F02\u5E38\u7684\u60C5\u51B5\uFF0C\u8FDB\u884Ccatch\u5904\u7406\uFF0C\u6BCF\u6B21\u4E00\u5B9A\u8981\u5BF9\u8FD4\u56DE\u7684data\u6570\u636E\u505A\u7C7B\u578B\u5224\u65AD\uFF0C\u6BD4\u5982\uFF0C\u4F60\u9700\u8981\u7684\u662F\u6570\u7EC4\u6570\u636E\uFF0C\u4F46\u662F\u63A5\u53E3\u5728\u7A7A\u7684\u65F6\u5019\u5F88\u53EF\u80FD\u4F1A\u7ED9\u4F60\u8FD4\u56DE\u4E00\u4E2Anull\uFF0C\u8FD9\u6B64\u903B\u8F91\u9700\u8981\u524D\u7AEF\u5904\u7406\u6389\uFF0C\u53EF\u4EE5\u5C01\u88C5\u5904\u7406\uFF0C\u4E5F\u53EF\u4EE5\u72EC\u7ACB\u5904\u7406\uFF0C\u63A8\u8350\u548C\u540E\u7AEF\u7EC4\u534F\u5546\u597D\u89C4\u8303\uFF0C\u8FDB\u884C\u5C01\u88C5\u5904\u7406\u64CD\u4F5C\u3002</li></ul></p><h2 style="margin-top:40px;" data-v-5fbdf560>\u5982\u4F55\u4F7F\u7528Mock\u6570\u636E</h2><p data-v-5fbdf560><b data-v-5fbdf560>\u4F7F\u7528\u672C\u5730Mock\u6570\u636E</b></p><p data-v-5fbdf560><ul data-v-5fbdf560><li data-v-5fbdf560>1. \u4F7F\u7528\u672C\u5730Mock\u6570\u636E\u7684\u65F6\u5019\uFF0C\u6211\u4EEC\u53EF\u4EE5\u5728\u6587\u4EF6\u5939\uFF1A\u9879\u76EE\u6839\u76EE\u5F55/mock/ \u91CC\u9762\u65B0\u589E\u4E00\u4E2A\u6587\u4EF6\uFF0C\u6765\u5B9A\u4E49mock\u51FD\u6570,\u5E76\u5728: \u9879\u76EE\u6839\u76EE\u5F55/mockProdServer.ts\u6587\u4EF6\u91CC\u9762\u5F15\u5165\uFF0C\u56E0\u4E3A\u7EBF\u4E0A\u662F\u9700\u8981\u81EA\u884C\u5F15\u5165\u7684\uFF08\u5907\u6CE8\uFF1A\u540E\u671F\u53EF\u80FD\u4F1A\u6362\u6210\u81EA\u52A8\u5F15\u5165\u7684\u5199\u6CD5\uFF09</li><li data-v-5fbdf560>2. \u7136\u540E\u5728\uFF1Asrc/api/* \u91CC\u9762\u5199\u63A5\u53E3\u8C03\u7528\uFF0C\u5E76\u5B9A\u4E49baseUrl\u4E3A\u201C/mock\u201D\uFF0C\u53EF\u53C2\u7167\u6587\u4EF6src/api/user.ts</li><li data-v-5fbdf560>3. \u7136\u540E\u5728\u9875\u9762\u5185\u5F15\u5165\u8FD9\u4E2A\u6587\u4EF6\u5185\u7684\u5BF9\u5E94\u51FD\u6570\u4F7F\u7528\u5373\u53EF</li><li data-v-5fbdf560>4. \u8FD9\u6837\u7684\u914D\u7F6E\u53EF\u4EE5\u4F7F\u5F97\u5927\u5BB6\u5728\u524D\u671F\u5F00\u53D1\u8FC7\u7A0B\u4E2D\u4F7F\u7528\u81EA\u5DF1\u7684\u63A5\u53E3\uFF0C\u7136\u540E\u5728\u540E\u671F\u540E\u7AEF\u5199\u597D\u63A5\u53E3\u540E\uFF0C\u76F4\u63A5\u66FF\u6362\u771F\u5B9E\u63A5\u53E3\u5373\u53EF</li><li data-v-5fbdf560>5. \u5982\u679C\u6709\u60F3\u72EC\u7ACB\u524D\u7AEF\u9879\u76EE\u4E3A\u81EA\u5DF1\u7B80\u5386\u4F5C\u54C1\u7684\u65F6\u5019\uFF0C\u8FD9\u4E2A\u529F\u80FD\u5C31\u5F88Nice\u4E86\uFF0C\u6BCF\u6B21\u66FF\u6362\u4E00\u4E0B\u540E\u7AEF\u63A5\u53E3\u548C\u5185\u5BB9\u81F3mock\u865A\u62DF\u6570\u636E\u7684\u5730\u65B9\uFF0C\u5373\u4F7F\u79BB\u804C\u540E\uFF0C\u4F60\u7684\u524D\u671F\u9879\u76EE\u4E5F\u80FD\u8DD1\u8D77\u6765\u5F53\u7B80\u5386\u7528\uFF0C\u8FD8\u662FNice\u3002</li></ul></p><p data-v-5fbdf560><b data-v-5fbdf560>\u4F7F\u7528\u5728\u7EBFMock\u6570\u636E</b></p><p data-v-5fbdf560><ul data-v-5fbdf560><li data-v-5fbdf560>1. \u5728\u4EFB\u610F\u5728\u7EBFmock\u5E73\u53F0\u5EFA\u7ACB\u9879\u76EE\uFF0C\u5E76\u5EFA\u7ACBmock\u6A21\u62DF\u63A5\u53E3</li><li data-v-5fbdf560>2. \u5728vite.config.ts\u91CC\u9762\uFF0C\u5B9A\u4E49\u4E00\u4E2A\u65B0\u7684proxy\uFF0C\u63A8\u8350\u540D\u79F0\uFF1A\u201ConlineMock\u201D\uFF0C \u53EF\u53C2\u8003\u6587\u4EF6\u5185\u90E8\uFF1Aserver.proxy\u5BF9\u8C61\u5185\u90E8\u7684\u5199\u6CD5\uFF0C\u518D\u65B0\u589E\u4E00\u884C\uFF0C\u7C7B\u4F3C\u5199\u6CD5\u5373\u53EF\uFF0C\u66F4\u591A\u8D44\u6599\u8BF7\u53BBvite\u5B98\u7F51\u627E\u4E00\u4E0B\u3002</li><li data-v-5fbdf560>3. \u7136\u540E\u5728\uFF1Asrc/api/* \u91CC\u9762\u5199\u63A5\u53E3\u8C03\u7528\uFF0C\u5E76\u5B9A\u4E49baseUrl\u4E3A\u201C/onlineMock\u201D\uFF0C\u53EF\u53C2\u7167\u6587\u4EF6src/api/user.ts</li><li data-v-5fbdf560>4. \u6700\u540E\u5728\u9875\u9762\u5185\u5F15\u5165\u8FD9\u4E2A\u6587\u4EF6\u5185\u7684\u5BF9\u5E94\u51FD\u6570\u4F7F\u7528\u5373\u53EF </li><li data-v-5fbdf560>5. \u672C\u5730mock\u4F7F\u7528\u7684\u662FJS\u62E6\u622A\u673A\u5236\uFF0C\u672C\u5730\u5F00\u53D1\u65F6\u6709\u63A5\u53E3\u8BF7\u6C42\uFF0C\u7EBF\u4E0A\u4F7F\u7528\u65F6\u65E0\u63A5\u53E3\u8BF7\u6C42\uFF0C\u62E6\u622A\u7684\u662FJS\u4E8B\u4EF6\u3002</li></ul></p><h2 style="margin-top:40px;" data-v-5fbdf560>\u5982\u4F55\u4F7F\u7528\u771F\u5B9E\u540E\u7AEF\u63A5\u53E3</h2><p data-v-5fbdf560>\u5728\u4F7F\u7528\u63A5\u53E3\u7684\u65F6\u5019\uFF0C\u9700\u8981\u5148\u884C\u53BB\u9664api\u6587\u4EF6\u5939\u91CC\u9762\u5BF9\u5E94\u63A5\u53E3\u7684baseUrl\uFF0C\u76F4\u63A5\u53BB\u6389\u5373\u53EF</p><p data-v-5fbdf560><b data-v-5fbdf560>\u4F7F\u7528\u4EE3\u7406</b></p><p data-v-5fbdf560><ul data-v-5fbdf560><li data-v-5fbdf560>1. \u672C\u5730\u8C03\u8BD5\u7684\u65F6\u5019\uFF0C\u9700\u8981\u5173\u6CE8vite.config.ts\u91CC\u9762\u914D\u7F6E\u7684\u4EE3\u7406\u5BF9\u5E94\u7684\u5730\u5740\u662F\u5426\u6B63\u5E38\uFF0C\u53EF\u4EE5\u7528Postman\u81EA\u884C\u6D4B\u8BD5\u4E00\u4E0B\u63A5\u53E3\u662F\u5426\u53EF\u7528</li><li data-v-5fbdf560>2. src/api\u6587\u4EF6\u5939\u91CC\u9762\u5199\u63A5\u53E3\u7684\u65F6\u5019\uFF0C\u8981\u628A\u4EE3\u7406\u7684\u5B57\u7B26\u4E32\u548C\u771F\u5B9E\u7684\u5B57\u7B26\u4E32\u5206\u5F00\uFF0C\u5982\uFF1Ahttp://vue-admin-box.51weblove.com/api/table/list\uFF0C\u5199\u4EE3\u7406\u7684\u65F6\u5019\uFF0C\u5E94\u8BE5\u628A\uFF1A&#39;http://vue-admin-box.51weblove.com/api&#39;\u4EE3\u7406\u5230&#39;api&#39;\uFF0C\u7136\u540E\u5728\u63A5\u53E3\u91CC\u9762\u5C31\u53EA\u7528\u5199path\u4E3A\uFF1A&#39;table/list&#39;\u3002</li><li data-v-5fbdf560>3. \u4EE3\u7406\u8BBE\u7F6E\u540E\uFF0C\u4F60\u5728\u5F00\u53D1\u8005\u5DE5\u5177\u91CC\u9762\u770B\u5230\u7684\u63A5\u53E3\uFF1A\u6700\u7EC8\u57DF\u540D\u5C31\u662F\u4F60\u73B0\u5728\u9879\u76EE\u7684\u57DF\u540D\uFF0C\u5982\uFF1Ahttp://localhost:3000/api/table/list\uFF0C\u4E0D\u8981\u7591\u60D1\uFF0C\u5B9E\u9645\u4E0A\u8BBF\u95EE\u7684\u662F\uFF1Ahttp://vue-admin-box.51weblove.com/api/table/list</li><li data-v-5fbdf560>4. \u63A8\u8350\u5927\u5BB6\u4F7F\u7528\u4EE3\u7406\uFF0C\u8FD9\u6837\u524D\u7AEF\u6CA1\u8DE8\u57DF\u95EE\u9898\uFF0C\u540E\u7AEF\u4E5F\u4E0D\u7528\u5904\u7406\u4E00\u5806\u4E1C\u897F\uFF0C\u4F60\u597D\u6211\u597D\u5927\u5BB6\u597D\uFF0C\u8BA9\u540E\u7AEF\u548C\u4F60\u5408\u4F5C\u4E5F\u6BD4\u8F83\u723D\u3002</li><li data-v-5fbdf560>5. \u5728\u4E0A\u7EBF\u7684\u65F6\u5019\uFF0C\u5927\u5BB6\u4E5F\u5F97\u8981\u914D\u7F6E\u4E00\u4E0B\u5BF9\u5E94\u7684\u670D\u52A1\u5668\uFF0C\u6BD4\u5982Nginx\u5C31\u5E94\u8BE5\u914D\u7F6E\u4E00\u4E0B\u4EE3\u7406\u8BBE\u7F6E\uFF0C \u628A\u4F60\u60F3\u8981\u4EE3\u7406\u7684\u63A5\u53E3\u524D\u7F00\u914D\u7F6E\u4E00\u4E0B\uFF0C\u8FD9\u6837\u7EBF\u4E0A\u771F\u5B9E\u9879\u76EE\u624D\u80FD\u6B63\u5E38\u8BBF\u95EE\u3002</li><li data-v-5fbdf560>6. \u5982\u679C\u4F60\u5BF9\u6027\u80FD\u6709\u6781\u81F4\u7684\u8FFD\u6C42\uFF0C\u90A3\u5C31\u4E0D\u8981\u4F7F\u7528\u4EE3\u7406\u4E86\uFF0C\u56E0\u4E3A\u5B83\u4F1A\u8BA9\u4F60\u7684\u670D\u52A1\u5668\u8FD8\u5145\u5F53\u4E00\u4E2A\u63A5\u53E3\u4E2D\u8F6C\u7AD9\u7684\u89D2\u8272\u3002\u4F46\u5728\u6211\u81EA\u5DF1\u7684\u5E73\u65F6\u4F7F\u7528\u4E2D\uFF0C\u56E0\u4E3A\u540E\u53F0\u4F7F\u7528\u9891\u7387\u5176\u5B9E\u662F\u8FDC\u8FDC\u4E0D\u5982\u524D\u53F0\u9875\u9762\u7684\uFF0C\u6240\u4EE5\u6211\u7EDD\u5927\u90E8\u5206\u65F6\u5019\u90FD\u662F\u4F7F\u7528\u7684\u4EE3\u7406\u3002</li></ul></p><p data-v-5fbdf560><b data-v-5fbdf560>\u76F4\u63A5\u4F7F\u7528\u63A5\u53E3\u5730\u5740</b></p><p data-v-5fbdf560><ul data-v-5fbdf560><li data-v-5fbdf560>1. \u8BF7\u5148\u5173\u6CE8\u9879\u76EE\u6839\u76EE\u5F55\u4E09\u4E2A\u6587\u4EF6\uFF1A .env.development, .env.production, .env.staging\u6587\u4EF6\uFF0C\u5206\u522B\u5BF9\u5E94\u5F00\u53D1\u73AF\u5883\u3001\u751F\u4EA7\u73AF\u5883\u3001\u6D4B\u8BD5\u73AF\u5883</li><li data-v-5fbdf560>2. \u9700\u8981\u4FEE\u6539\u4E09\u4E2A\u6587\u4EF6\u4E2D\u7684VITE_BASE_URL\u53D8\u91CF\uFF0C\u628A\u5B83\u6362\u6210\u4F60\u7684\u771F\u5B9E\u63A5\u53E3\u5730\u5740\u524D\u7F00</li><li data-v-5fbdf560>3. \u8FD9\u65F6\u5019\u518D\u542F\u52A8\u9879\u76EE\u8BBF\u95EE\uFF0C\u4F60\u4F1A\u53D1\u73B0\uFF0C\u63A5\u53E3\u8BF7\u6C42\u5C31\u53D8\u6210\u4E86\u4F60\u9700\u8981\u7684\u771F\u5B9E\u63A5\u53E3\u8BF7\u6C42\u4E86\u3002</li></ul></p></section></article>',2),d=[D];function t(f,i,l,b,e,v){return E(),C("div",A,d)}var o=u(a,[["render",t],["__scopeId","data-v-5fbdf560"]]);export{o as default};
