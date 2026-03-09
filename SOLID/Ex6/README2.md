# My Quick Notes for Solving LSP (Liskov Substitution Principle) Problems

These are the mental checks I run whenever I see inheritance in a design question.

LSP in simple words:

> If code works with the parent class, it should work with any child class without breaking the program.

So if this works:

NotificationSender sender = new EmailSender();

Then this should also work without surprises:

NotificationSender sender = new WhatsAppSender();

If switching children suddenly causes errors or strange behavior → **LSP is broken**.

---

# 0. Domain Rule vs Technical Constraint (First Thing I Check)

Before changing the design I ask:

**Is the rule part of the real-world domain, or just a technical limitation?**

### Domain rule
These belong to the system and are valid constraints.

Example:
- WhatsApp requires `+country code` numbers
- Email requires a valid email address

Solution:
Extract validation.

Example:

Notification  
→ Validator  
→ Sender

---

### Technical constraint
These are limitations of an implementation, not the domain.

Example:
- PDF exporter refusing long content
- File format limitations

This usually means the **abstraction is wrong**, not just the implementation.

Solution:
Redesign the abstraction.

Example:

Exporter  
→ Encoder (format logic)

---

# 1. Find the Promise of the Parent Class

The first real step is identifying the **contract the parent implies**.

Ask:

**What is this parent class promising?**

Example:

Exporter  
export(request)

Implicit promise:

Any exporter should be able to export the request.

---

Example:

NotificationSender  
send(notification)

Implicit promise:

Any sender should be able to send a notification.

If that promise cannot hold for all children, the design is wrong.

---

# 2. Test Every Child Against the Promise

Now mentally replace the parent with each subclass.

Ask:

**Can this child truly do what the parent promises?**

Example (Notification):

EmailSender  
✔ sends message

SmsSender  
✔ sends message

WhatsAppSender  
✔ sends message (if number valid)

Important observation:

All subclasses still **send notifications**.

So the abstraction **NotificationSender is valid**.

---

Example (Exporter):

PdfExporter  
❌ refuses long content

CsvExporter  
⚠ corrupts data semantics

JsonExporter  
⚠ behaves differently for null

Important realization:

PdfExporter **cannot always export a request**.

So the abstraction **Exporter is flawed**.

---

# 3. Decide the Type of Problem

There are usually two kinds of LSP problems.

---

## Case A — Abstraction is Correct (Responsibilities Mixed)

Children can still perform the parent’s job, but they mix extra behavior.

Example:

EmailSender
- truncates body
- sends email

WhatsAppSender
- validates phone
- sends message

Problem:

Too many responsibilities inside subclasses.

Solution:

Extract the responsibilities.

Example:

Notification  
→ Validator  
→ Sender

Sender now only sends.

---

## Case B — Abstraction is Wrong

If a subclass **cannot fulfill the parent's job**, inheritance is wrong.

Example:

PdfExporter cannot export large content.

But the parent implies:

Exporter should export any request.

This mismatch means the abstraction is wrong.

Solution:

Redesign the architecture.

Example:

Exporter → orchestration  
Encoder → format logic

Now each encoder handles a format properly.

---

# 4. Common Signs of LSP Violations

These are red flags I look for.

---

### Child Rejects Inputs Parent Accepts

Example:

Parent accepts long text  
Child throws error for long text

This **tightens preconditions** → LSP violation.

---

### Child Changes Meaning of Data

Example:

CsvExporter replacing commas/newlines incorrectly.

This corrupts the data semantics.

---

### Child Behaves Differently From Others

Example:

JsonExporter returning empty output for null while others throw.

The system becomes unpredictable.

---

### Subclasses Doing Too Many Jobs

Example:

EmailSender doing:
- validation
- formatting
- sending

Usually means responsibilities need to be separated.

---

# 5. Final Decision Rule

When solving LSP questions I always run this checklist:

1. What does the parent promise?
2. Can every child fulfill that promise?
3. Is this rule a domain rule or technical limitation?
4. If abstraction is correct → extract responsibilities.
5. If abstraction is wrong → redesign the hierarchy.

---

# One Line Summary

If children **can still do the parent’s job**, extract responsibilities.

If children **cannot do the parent’s job**, the abstraction itself must change.