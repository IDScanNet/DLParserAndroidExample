/*
 * Copyright (c) 2017 IDScan.net
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 * Support: support@idscan.net
 */

package net.idscan.android.dlparserandroidexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import net.idscan.android.dlparser.DLParser;
import net.idscan.android.dlparser.DLParser.DLParserException;
import net.idscan.android.dlparser.DLParser.DLResult;

import java.io.UnsupportedEncodingException;

public class MainActivity extends AppCompatActivity {
    private DLParser parser = null;
    private static final String _KEY = "CF47wsW6ZAj2eZ4Mdfo72+k9Q61wQbemMf+EtZxMBHaS/J2xOhk7+T6zMRKf8Jb3dWV6RSBfp1/H/Nc/MnI23yV8qTH+NnyEhb/MLcnQ7gQpao0adr+yITXuHUJiXWu5q4FH58owjMNy1UMNggFqrqkh99XT//kdRthrWP1+GdU=";
    final String test_data = "%MNBURNSVILLE^HOMER J. SYMPSON^13225 MADRID RD^?\n\n;636038326007403611=12091991090106?\n\n%\" 55306      D               F064124   HZL                           X\"+H)     ?";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        parser = new DLParser();
        ((TextView) findViewById(R.id.tv_version)).setText(parser.getVersion());
        try {
            // Setup parser.
            parser.setup(getApplicationContext(), _KEY);
            // Parse the data.
            DLResult res = parser.parse(test_data.getBytes("UTF8"));

            ((TextView) findViewById(R.id.tv_first_name)).setText(res.firstName);
            ((TextView) findViewById(R.id.tv_middle_name)).setText(res.middleName);
            ((TextView) findViewById(R.id.tv_last_name)).setText(res.lastName);
            ((TextView) findViewById(R.id.tv_address)).setText(res.address1);
            ((TextView) findViewById(R.id.tv_birthdate)).setText(res.birthdate);
            ((TextView) findViewById(R.id.tv_expiration_date)).setText(res.expirationDate);
            ((TextView) findViewById(R.id.tv_version)).setText(parser.getVersion());
        } catch (DLParserException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}

